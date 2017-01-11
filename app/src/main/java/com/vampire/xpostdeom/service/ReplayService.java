package com.vampire.xpostdeom.service;/**
 * Created by tarena on 2017/1/6.
 */

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.vampire.xpostdeom.bean.ChatBean;
import com.vampire.xpostdeom.bean.OverBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * created by Vampire
 * on: 2017/1/6 下午4:22
 */
public class ReplayService extends AccessibilityService {
    private static final String TAG = "ReplayService-vampire";
    private String question = null;
    private String className;
    private String answer = "vampire";
    private boolean isBreak = true;
    private boolean locked = false;
    private String tempQuestion = "";
    private boolean background = false;
    private KeyguardManager.KeyguardLock kl;

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void getQuestion(ChatBean chatBean) {
        question = chatBean.getContent();// 回复完成 将Question重置
        if (chatBean.getContent().equals("VampireVampireVampireVampireVampire")) {
            isBreak = false;
        } else {

        }
//        Log.d(TAG, "question" + question);
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        int eventType = accessibilityEvent.getEventType();
        Log.d(TAG, "eventType:" + eventType);
        Log.d(TAG, accessibilityEvent.getClassName().toString());
        Log.d(TAG, "accessibilityEvent.getAction():" + accessibilityEvent.getAction());

        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                className = accessibilityEvent.getClassName().toString();
                if (className.equals("com.tencent.mm.ui.chatting.ChattingUI")) {
                    Log.d(TAG, "fsdfsdfs");
                    while (isBreak) {
                        if (question != null) {
                            if (fill(answer)) {
                                Log.d(TAG, "in");
                                send();
                            }
                        }
                    }
                }
                break;
        }
    }

    /**
     * 寻找窗体中的“发送”按钮，并且点击。
     */
    @SuppressLint("NewApi")
    private void send() {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo
                    .findAccessibilityNodeInfosByText("发送");
            if (list != null && list.size() > 0) {
                for (AccessibilityNodeInfo n : list) {
                    if (n.getClassName() != null) {
                        Log.d(TAG, "!=null");
                        if (n.getClassName().equals("android.widget.Button") && n.isEnabled()) {
                            if (!question.equals(tempQuestion)) {
                                n.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                                EventBus.getDefault().post(new OverBean(true));
                                tempQuestion = question;
                            }
                            // 发送完成 回调
                        }
                    }

                }

            } else {
                List<AccessibilityNodeInfo> liste = nodeInfo
                        .findAccessibilityNodeInfosByText("Send");
                if (liste != null && liste.size() > 0) {
                    for (AccessibilityNodeInfo n : liste) {
                        if (n.getClassName().equals("android.widget.Button") && n.isEnabled()) {
                            if (!question.equals(tempQuestion)) {
                                n.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                                EventBus.getDefault().post(new OverBean(true));
                                tempQuestion = question;
                            }
                            // 发送完成 回调
                        }
                    }
                }
            }
        }

    }

    @SuppressLint("NewApi")
    private boolean fill(String infos) {
        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if (rootNode != null) {
            return findEditText(rootNode, infos);
        }
        return false;
    }


    private boolean findEditText(AccessibilityNodeInfo rootNode, String content) {
        int count = rootNode.getChildCount();
        Log.d(TAG, "root class=" + rootNode.getClassName() + "," + rootNode.getText() + "," + count);
        for (int i = 0; i < count; i++) {
            AccessibilityNodeInfo nodeInfo = rootNode.getChild(i);
            if (nodeInfo == null) {
                Log.d("maptrix", "nodeinfo = null");
                continue;
            }

            Log.d(TAG, "class=" + nodeInfo.getClassName());
            Log.e(TAG, "ds=" + nodeInfo.getContentDescription());

            if ("android.widget.EditText".equals(nodeInfo.getClassName())) {
                Bundle arguments = new Bundle();
                arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
                        AccessibilityNodeInfo.MOVEMENT_GRANULARITY_WORD);
                arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
                        true);
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY,
                        arguments);
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
                ClipData clip = ClipData.newPlainText("label", question);
                Log.d(TAG, "iiiiiiiiiiiiiiiiiiiii:" + i);
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setPrimaryClip(clip);
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_PASTE);

                return true;
            }

            if (findEditText(nodeInfo, content)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断指定的应用是否在前台运行
     *
     * @param packageName
     * @return
     */
    private boolean isAppForeground(String packageName) {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        String currentPackageName = cn.getPackageName();
        if (!TextUtils.isEmpty(currentPackageName) && currentPackageName.equals(packageName)) {
            return true;
        }

        return false;
    }

    /**
     * 回到系统桌面
     */
    private void backHome() {
        Intent home = new Intent(Intent.ACTION_MAIN);

        home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        home.addCategory(Intent.CATEGORY_HOME);

        startActivity(home);
    }

    /**
     * 系统是否在锁屏状态
     *
     * @return
     */
    private boolean isScreenLocked() {
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    private void wakeAndUnlock() {
        //获取电源管理器对象
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);

        //获取PowerManager.WakeLock对象，后面的参数|表示同时传入两个值，最后的是调试用的Tag
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");

        //点亮屏幕
        wl.acquire(1000);

        //得到键盘锁管理器对象
        KeyguardManager km = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        kl = km.newKeyguardLock("unLock");

        //解锁
        kl.disableKeyguard();

    }

    private void release() {

        if (locked && kl != null) {
            Log.d("maptrix", "release the lock");
            //得到键盘锁管理器对象
            kl.reenableKeyguard();
            locked = false;
        }
    }

    @Override
    public void onInterrupt() {

    }
}
