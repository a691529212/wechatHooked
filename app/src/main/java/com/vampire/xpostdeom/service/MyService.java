package com.vampire.xpostdeom.service;/**
 * Created by tarena on 2017/1/6.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;

import com.vampire.xpostdeom.MainActivity;
import com.vampire.xpostdeom.R;
import com.vampire.xpostdeom.bean.ChatBean;
import com.vampire.xpostdeom.bean.OverBean;
import com.vampire.xpostdeom.utils.FileUtils;
import com.vampire.xpostdeom.utils.ShellUtils;
import com.vampire.xpostdeom.bean.TextReader;
import com.vampire.xpostdeom.hook.path.XPosedSettingHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * created by Vampire
 * on: 2017/1/6 下午1:47
 */
public class MyService extends Service {
    private static final String TAG = "MyService-vampire";
    private String tempTalker = "";
    private String answer = "Vampire";
    private ChatBean chatBean;
    private boolean isOver;
    private String[] messageQueeen;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Subscribe
    public void getOver(OverBean overBean) {
        isOver = overBean.isOver();
        Log.d(TAG, "isOver:" + isOver);
        Log.d(TAG, "pas");
//        List<String> list = Arrays.asList(messageQueeen);
//        final List<String> temp = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            if (i > 0) {
//                temp.add(list.get(i));
//            }
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                FileUtils.writeFile("/sdcard/chatting.txt", temp);
//            }
//        }).start();
    }

    @Subscribe
    public void getReader(TextReader textReader) throws IOException, InterruptedException, IndexOutOfBoundsException {
        String reader = textReader.getString();
        messageQueeen = reader.split("\n");
        Log.d(TAG, "get");
        if (messageQueeen.length > 0) {
            for (int i = 0; i < messageQueeen.length; i++) {
                isOver = false;
                String[] strings = messageQueeen[i].split("@@");
//                if (!tempTalker.equals(strings[0])) {
                String[] shell = new String[]{"am start -n com.tencent.mm/com.tencent.mm.ui.chatting.ChattingUI -e Chat_User " + strings[0]};
                int result = ShellUtils.execCommand(shell, true).result;
                Log.d(TAG, "result:" + result);
                tempTalker = strings[0];
//                }
                chatBean = new ChatBean();
                chatBean.setContent(strings[1]);
                chatBean.setTalkerID(strings[0]);
                Log.d(TAG, "post");
                while (!isOver) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                EventBus.getDefault().post(chatBean);
                                Log.d(TAG, chatBean.getContent());
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
                Log.d(TAG, "do-next");
            }
            chatBean = new ChatBean();
            chatBean.setContent("VampireVampireVampireVampireVampire");
            EventBus.getDefault().post(chatBean);

//            }

        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        EventBus.getDefault().register(this);
        Context context = getApplicationContext();
        notificationInit(context);// 前台服务
        XPosedSettingHelper xPosedSettingHelper = new XPosedSettingHelper(getApplicationContext(), this.getPackageName());
        FileListener fileListener = new FileListener("/sdcard/chatting.txt");
        fileListener.startWatching();


        return super.onStartCommand(intent, flags, startId);

    }

    private void notificationInit(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        Intent mIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));
        // 点击消失
        builder.setAutoCancel(true);
        builder.setContentTitle("自动回复");


        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification = builder.build();
        // 设置滑动不取消
        notification.flags = Notification.FLAG_NO_CLEAR;
        // 设置单一通知
//        notificationManager.notify(0, notification);
        startForeground(1, notification);
    }
}
