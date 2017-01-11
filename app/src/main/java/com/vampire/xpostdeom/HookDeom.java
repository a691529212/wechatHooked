package com.vampire.xpostdeom;/**
 * Created by tarena on 2016/11/5.
 */

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseArray;

import com.vampire.xpostdeom.bean.ChatBean;
import com.vampire.xpostdeom.hook.path.XPosedSettingHelper;
import com.vampire.xpostdeom.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import dalvik.system.DexFile;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;
import static de.robv.android.xposed.XposedHelpers.getStaticObjectField;
import static de.robv.android.xposed.XposedHelpers.setStaticObjectField;

/**
 * created by Vampire
 * on: 2016/11/5 下午2:25
 */
public class HookDeom implements IXposedHookLoadPackage {

    private Context mContext;
    private int number = 5;
    private int head = 0;
    private SparseArray<HookHelper> hooks;
    private Class<?> aClass;

    public HookHelper getHooks(Context appContext, Context context, String pName, String vName, int uid) {
        HookHelper hookHelper;
        if (this.hooks == null) {
            this.hooks = new SparseArray<>();
        }
        if (this.hooks.indexOfKey(uid) != -1) {
            hookHelper = this.hooks.get(uid);
        } else {
            this.hooks.put(uid, new HookHelper(appContext, pName, context, vName));
            hookHelper = this.hooks.get(uid);
        }
        return hookHelper;
    }


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        String packageName = loadPackageParam.packageName;
        if (!(packageName.contains("com.tencent") && packageName.contains("mm")))
            return;
        Object activityThread = callStaticMethod(findClass("android.app.ActivityThread", null), "currentActivityThread");
        mContext = (Context) callMethod(activityThread, "getSystemContext");

        String versionName = mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;

        XposedBridge.log("Loaded app: " + loadPackageParam.packageName + " " + versionName);
//        findAndHookMethod(packageName + ".app.MMApplication",
//                loadPackageParam.classLoader, "onCreate",
//                new Object[]{new MyMethodHook(mContext, this, loadPackageParam, packageName, versionName)});
        try {
            hook(loadPackageParam);

        } catch (NullPointerException e) {

        }


//                hookWeChat(loadPackageParam);


    }

    private void hookWeChat(final XC_LoadPackage.LoadPackageParam loadPackageParam) {
//        findAndHookMethod("com.tencent.mm.ui.MMActivity", loadPackageParam.classLoader, "setContentView", View.class, new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//
//
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//            }
//        });

    }

    public void hook(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws IOException, ClassNotFoundException {

        // Hook所有方法
//        hookAllMethod(loadPackageParam);

        //hook 通知消息的msgId userName unReadCount
//        hookNotification(loadPackageParam);

        // hook存数据库1
//        hookInsertDb1(loadPackageParam);

        // hook存数据库2
//        hookInsertDb2(loadPackageParam);

        // hook骰子 剪刀石头布
//        hookGame(loadPackageParam);

        // hook查询数据库
//        hookQueryDb(loadPackageParam);

        try {
            hookTest(loadPackageParam);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

//        hookContentValues(loadPackageParam);

//        hookSendMsg(loadPackageParam);


    }

    private void hookTest(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws NoSuchFieldException {
//        aClass = findClass("com.tencent.mm.sdk.h.InitInterface$a", loadPackageParam.classLoader);
//        Map<String, String> map = (Map<String, String>) getStaticObjectField(aClass, "kbg");
//        XposedBridge.log(map.get("content"));
        findAndHookMethod("com.tencent.mm.pluginsdk.ui.chat.ChatFooter", loadPackageParam.classLoader, "i", String.class, int.class, boolean.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
//                        char[] chars = (char[]) param.args[0];
//                        for (char aChar : chars) {
//                            XposedBridge.log(String.valueOf(aChar));
//                        }

                        XposedBridge.log(String.valueOf(param.args[0]));
                        XposedBridge.log(String.valueOf(param.args[1]));
                        XposedBridge.log(String.valueOf(param.args[2]));
//                        XposedBridge.log("result: " + String.valueOf(param.getResult()));
                        int a = 0;
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        XposedBridge.log(String.valueOf(param.args[0]));
                        XposedBridge.log(String.valueOf(param.args[1]));
                        XposedBridge.log(String.valueOf(param.args[2]));
//                        XposedBridge.log("result: " + String.valueOf(param.getResult()));

                    }
                });
        findAndHookMethod("com.tencent.mm.pluginsdk.ui.chat.ChatFooter", loadPackageParam.classLoader, "i", int.class, int.class, boolean.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        XposedBridge.log("com.tencent.mm.sdk.platformtools.ba");


                        XposedBridge.log("double - before " + String.valueOf(param.args[0]));
                        XposedBridge.log("double - before " + String.valueOf(param.args[1]));
                        XposedBridge.log("double - before " + String.valueOf(param.args[2]));
//                        XposedBridge.log(String.valueOf(param.args[2]));
//                        XposedBridge.log("result" + String.valueOf(param.getResult()));
//                        String[] strings = (String[]) param.args[3];
//                        for (String string : strings) {
//                            XposedBridge.log(string);
//                        }

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        XposedBridge.log("com.tencent.mm.sdk.platformtools.ba");
//                        char[] chars = (char[]) param.args[0];
//                        for (char aChar : chars) {
//                            XposedBridge.log(String.valueOf(aChar));
//                        }
//
//                        XposedBridge.log(String.valueOf(param.args[1]));
                        XposedBridge.log("double - after " + String.valueOf(param.args[0]));
                        XposedBridge.log("double - after " + String.valueOf(param.args[1]));
                        XposedBridge.log("double - after " + String.valueOf(param.args[2]));
//                        XposedBridge.log("result" + String.valueOf(param.getResult()));

                    }
                });
    }

    // HOOK IP 上海电信
    private void hookIP(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        findAndHookMethod("com.tencent.mm.s.m", loadPackageParam.classLoader, "getNetworkServerIp", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(String.valueOf(param.getResult()));
            }
        });
    }

    private void hookSendMsg(XC_LoadPackage.LoadPackageParam loadPackageParam) {


        findAndHookMethod("com.tencent.mm.ui.chatting.aa", loadPackageParam.classLoader, "getTalkerUserName", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("aishiyu123");
                XposedBridge.log("微信Id: " + (String) param.getResult());
            }

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

            }
        });
        //文本类型发送消息
        findAndHookMethod("com.tencent.mm.ui.chatting.aa", loadPackageParam.classLoader, "rM", String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                XposedBridge.log("消息内容: " + param.args[0]);

            }

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }
        });
    }

    private void hookContentValues(final XC_LoadPackage.LoadPackageParam loadPackageParam) {
        findAndHookMethod("com.tencent.mm.d.InitInterfaceB.bi", loadPackageParam.classLoader, "kE", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        List<ChatBean> chatBeen = new ArrayList<ChatBean>();
                        XposedBridge.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        ContentValues contentValues = (ContentValues) param.getResult();
                        int isSend = (int) contentValues.get("isSend");
                        if (isSend == 0) {
                            //接收
                            XPosedSettingHelper xPosedSettingHelper = new XPosedSettingHelper("com.vampire.xpostdeom");
                            String talkerID = (String) contentValues.get("talker");
                            String content = (String) contentValues.get("content");
                            FileUtils.writeFile("/sdcard/chatting.txt", talkerID + "@@" + content + "\n", true);
//                            xPosedSettingHelper.setString("filePath", file.getParent());

                        } else {


                        }
                        XposedBridge.log("msgId: " + String.valueOf(contentValues.get("msgId")));
                        XposedBridge.log("msgSvrId: " + String.valueOf(contentValues.get("msgSvrId")));
                        XposedBridge.log("type: " + String.valueOf(contentValues.get("type")));
                        XposedBridge.log("statue:" + String.valueOf(contentValues.get("statue")));
                        XposedBridge.log("isSend: " + String.valueOf(contentValues.get("isSend")));
                        XposedBridge.log("isShowTimer: " + String.valueOf(contentValues.get("isShowTimer")));
                        XposedBridge.log("createTime:" + String.valueOf(contentValues.get("createTime")));
                        XposedBridge.log("talker: " + String.valueOf(contentValues.get("talker")));
                        XposedBridge.log("content：" + String.valueOf(contentValues.get("content")));
                        XposedBridge.log("imgPath：" + String.valueOf(contentValues.get("imgPath")));
                        XposedBridge.log("reserved：" + String.valueOf(contentValues.get("reserved")));
                        XposedBridge.log("lvbuffer：" + String.valueOf(contentValues.get("lvbuffer")));
                        XposedBridge.log("talkerId：" + String.valueOf(contentValues.get("talkerId")));
                        XposedBridge.log("transContent：" + String.valueOf(contentValues.get("transContent")));
                        XposedBridge.log("transBrandWording：" + String.valueOf(contentValues.get("transBrandWording")));
                        XposedBridge.log("bizClientMsgId：" + String.valueOf(contentValues.get("bizClientMsgId")));
                        XposedBridge.log("bizChatId：" + String.valueOf(contentValues.get("bizChatId")));
                        XposedBridge.log("bizChatUserId：" + String.valueOf(contentValues.get("bizChatUserId")));
                        XposedBridge.log("msgSeq：" + String.valueOf(contentValues.get("msgSeq")));
                        XposedBridge.log("flag：" + String.valueOf(contentValues.get("flag")));
                        XposedBridge.log("rowid：" + String.valueOf(contentValues.get("rowid")));
                        contentValues.put("isSend", 0);
                        callMethod(XposedHelpers.findClass("com.tencent.mm.d.InitInterfaceB.bi", loadPackageParam.classLoader), "kE");

                    }

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable, NullPointerException {
                        super.beforeHookedMethod(param);
//                XposedBridge.log(String.valueOf(param.args[0]));

                        ContentValues contentValues = (ContentValues) param.getResult();
                        XposedBridge.log("msgId: " + String.valueOf(contentValues.get("msgId")));
                        XposedBridge.log("msgSvrId: " + String.valueOf(contentValues.get("msgSvrId")));
                        XposedBridge.log("type: " + String.valueOf(contentValues.get("type")));
                        XposedBridge.log("statue:" + String.valueOf(contentValues.get("statue")));
                        XposedBridge.log("isSend: " + String.valueOf(contentValues.get("isSend")));
                        XposedBridge.log("isShowTimer: " + String.valueOf(contentValues.get("isShowTimer")));
                        XposedBridge.log("createTime:" + String.valueOf(contentValues.get("createTime")));
                        XposedBridge.log("talker: " + String.valueOf(contentValues.get("talker")));
                        XposedBridge.log("content：" + String.valueOf(contentValues.get("content")));
                        XposedBridge.log("imgPath：" + String.valueOf(contentValues.get("imgPath")));
                        XposedBridge.log("reserved：" + String.valueOf(contentValues.get("reserved")));
                        XposedBridge.log("lvbuffer：" + String.valueOf(contentValues.get("lvbuffer")));
                        XposedBridge.log("talkerId：" + String.valueOf(contentValues.get("talkerId")));
                        XposedBridge.log("transContent：" + String.valueOf(contentValues.get("transContent")));
                        XposedBridge.log("transBrandWording：" + String.valueOf(contentValues.get("transBrandWording")));
                        XposedBridge.log("bizClientMsgId：" + String.valueOf(contentValues.get("bizClientMsgId")));
                        XposedBridge.log("bizChatId：" + String.valueOf(contentValues.get("bizChatId")));
                        XposedBridge.log("bizChatUserId：" + String.valueOf(contentValues.get("bizChatUserId")));
                        XposedBridge.log("msgSeq：" + String.valueOf(contentValues.get("msgSeq")));
                        XposedBridge.log("flag：" + String.valueOf(contentValues.get("flag")));
                        XposedBridge.log("rowid：" + String.valueOf(contentValues.get("rowid")));


                    }
                }

        );
    }

    private void hookGame(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        findAndHookMethod("com.tencent.mm.sdk.platformtools.ba", loadPackageParam.classLoader, "pT", int.class, new XC_MethodReplacement() {
            private int count;
            XPosedSettingHelper helper = new XPosedSettingHelper("com.vampire.xpostdeom");

            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                int gameType = (Integer) methodHookParam.args[0];
                Uri uri = Uri.parse("content://com.example.hookdemo.provider/wx_plugs_setting");
                Cursor cursor = mContext.getContentResolver().query(uri, null, null, null, null);
                switch (gameType) {
                    case 5://骰子
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                count = cursor.getInt(cursor.getColumnIndex("dice_num"));
                                XposedBridge.log("掷骰子点数为:" + count);
                                count = helper.getInt("dice", 5); // 六点
                            }
                        }
                        break;
                    case 2://猜拳
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                count = cursor.getInt(cursor.getColumnIndex("morra_num"));
                                count = helper.getInt("head", 0);
                                XposedBridge.log("猜拳数为:" + count);
                                // 0 , 1 ,2  剪刀  石头 布
                            }
                        }
                        break;
                }
                XposedBridge.log("replaceHookedMethod--函数返回值:" + count);
                return count;
            }
        });
    }

    private void hookQueryDb(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        findAndHookMethod("com.tencent.mm.bc.e", loadPackageParam.classLoader, "query", String.class, String[].class, String.class, String[].class, String.class, String.class, String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
//                XposedBridge.log("com.tencent.mm.bc.e query afterHookedMethod");
//                XposedBridge.log("S1:" + param.args[0]);
//
//                XposedBridge.log("S2 :" + param.args[2]);
//                try {
//                    String[] strings = (String[]) param.args[1];
//                    for (String string : strings) {
//                        XposedBridge.log("string[]1: " + string);
//                    }
//                    String[] strings1 = (String[]) param.args[3];
//                    for (String s : strings1) {
//                        XposedBridge.log("String[] 2 : " + s);
//                    }
//                } catch (NullPointerException e) {
//                    XposedBridge.log("NullPointerException");
//                }
//
//                XposedBridge.log("S3 :" + param.args[4]);
//                XposedBridge.log("S4 :" + param.args[5]);
//                XposedBridge.log("S5 :" + param.args[6]);
//                Cursor cursor = (Cursor) param.getResult();
//                while (cursor.moveToNext()){
//                    cursor.getColumnCount();
//                }
//                for (int i = 0; !cursor.isLast(); i++) {
//
//
//                }
//

            }

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
//                XposedBridge.log("com.tencent.mm.bc.e query afterHookedMethod");
//                XposedBridge.log("S1:" + param.args[0]);
//                try {
//                    String[] strings = (String[]) param.args[1];
//                    for (String string : strings) {
//                        XposedBridge.log("string[]1: " + string);
//                    }
//                    String[] strings1 = (String[]) param.args[3];
//                    for (String s : strings1) {
//                        XposedBridge.log("String[] 2 : " + s);
//                    }
//                } catch (NullPointerException e) {
//                    XposedBridge.log("NullPointerException");
//                }
//
//                XposedBridge.log("S2 :" + param.args[2]);
//
//                XposedBridge.log("S3 :" + param.args[4]);
//                XposedBridge.log("S4 :" + param.args[5]);
//                XposedBridge.log("S5 :" + param.args[6]);
            }
        });
    }

    private void hookInsertDb2(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        findAndHookMethod("com.tencent.mm.bc.e", loadPackageParam.classLoader, "insert", String.class, String.class, ContentValues.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                if (param.args[0].equals("message")) {
//                    XposedBridge.log("com.tencent.mm.bc.g afterHookedMethod ------------------");
//                XposedBridge.log("insert string1 : " + param.getClass().getCanonicalName());
//                XposedBridge.log("insert string2 : " + param.getClass().getName());
                    ContentValues args = (ContentValues) param.args[2];
                    try {
//                    XposedBridge.log(param.getClass().getClass().getName());
//                    XposedBridge.log(param.getClass().getClass().getClass().getName());
//                        XposedBridge.log("content: " + (String) args.get("content"));
//                        XposedBridge.log("talker: " + (String) args.get("talker"));
////                    XposedBridge.log("createTime: " +(String) args.get("createTime"));
//                        XposedBridge.log("isSend: " + (String) args.get("issend"));
//                        XposedBridge.log("type: " + (String) args.get("type"));

                    } catch (Exception e) {
                        XposedBridge.log(e.toString());
                    }
                }

            }

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (param.args[0].equals("message")) {
//                    XposedBridge.log("com.tencent.mm.bc.e beforeHookedMethod ");
//                    XposedBridge.log("insert string1 : " + param.args[0]);
//                    XposedBridge.log("insert string2 : " + param.args[1]);
                    ContentValues args = (ContentValues) param.args[2];
                    try {
//                        XposedBridge.log("content: " + (String) args.get("content"));
//                        XposedBridge.log("talker: " + (String) args.get("talker"));
//                    args.put("content", "Vampire");
//                    XposedBridge.log("createTime: " +(String) args.get("createTime"));
//                    XposedBridge.log("type: " + (String) args.get("type"));
//                        XposedBridge.log(String.valueOf(args.get("issend")));
//                        XposedBridge.log("statue: " + (String) args.get("statue"));
//                        XposedBridge.log("type: " + (String) args.get("type"));

                    } catch (Exception e) {
                        XposedBridge.log(e.toString());

                    }
                }
            }
        });
    }

    private void hookInsertDb1(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        findAndHookMethod("com.tencent.mm.bc.g", loadPackageParam.classLoader, "insert", String.class, String.class, ContentValues.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                XposedBridge.log("com.tencent.mm.bc.g afterHookedMethod ----------------");
                XposedBridge.log("insert string1 : " + param.args[0]);
                XposedBridge.log("insert string2 : " + param.args[1]);
//                XposedBridge.log((String) param.getResult());
                ContentValues args = (ContentValues) param.args[2];
                try {
                    XposedBridge.log(args.getAsString(String.valueOf(param.args[0])));
                    XposedBridge.log(args.getAsString("talker"));
                    XposedBridge.log((String) args.get("content"));
                } catch (Exception e) {

                }
            }

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log("com.tencent.mm.bc.g beforeHookedMethod ------------------");
                XposedBridge.log("insert string1 : " + param.getClass().getCanonicalName());
                XposedBridge.log("insert string2 : " + param.getClass().getName());
                ContentValues args = (ContentValues) param.args[2];
                try {
                    XposedBridge.log(param.getClass().getClass().getName());
                    XposedBridge.log(param.getClass().getClass().getClass().getName());
//                    args.put("content", "Vampire");
                    XposedBridge.log("消息 : " + (String) args.get("content"));
                } catch (Exception e) {

                }

            }
        });
    }

    private void hookNotification(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        findAndHookMethod("com.tencent.mm.booter.notification.NotificationItem", loadPackageParam.classLoader, "toString", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                XposedBridge.log("beforeHookedMethod---");
                String s = (String) param.getResult();
                String[] split = s.split(",");
                XposedBridge.log("id:" + split[0]);
                XposedBridge.log("msgId:" + split[1]);
                XposedBridge.log("userName:" + split[2]);
                XposedBridge.log("unreadCount" + split[3]);
                String s1 = split[1];
                int i = s1.indexOf(":");
                s1 = s1.substring(i + 1);
                long[] longs = new long[]{Long.parseLong(s1)};

            }
        });
    }

    private void hookAllMethod(XC_LoadPackage.LoadPackageParam loadPackageParam) throws IOException, ClassNotFoundException {
        DexFile dexFile = new DexFile(loadPackageParam.appInfo.sourceDir);
        Enumeration<String> classNames = dexFile.entries();

        while (classNames.hasMoreElements()) {
            String className = classNames.nextElement();
            boolean b = className.startsWith(loadPackageParam.packageName)
                    && !className.contains("$")
                    && !className.contains("BuildConfig")
                    && !className.equals(loadPackageParam.packageName + ".R");
            if (b) {
                final Class clazz = Class.forName(className, false, loadPackageParam.classLoader);

                for (Method method : clazz.getDeclaredMethods()) {
                    if (!Modifier.isAbstract(method.getModifiers())) {
                        XposedBridge.hookMethod(method, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                log("HOOKED: " + clazz.getName() + "\\" + param.method.getName());
                                // param.method.getDeclaringClass() 获得调用方法的类
                            }
                        });
                    }
                }
            }
        }
    }

    public void log(Object str) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        //"[" + df.format(new Date()) + "]:  " +
        XposedBridge.log(str.toString());
    }


    /**
     * @param packageName 包名
     * @param versionName 版本号 - 6.3.16
     * @param uid         不知道
     * @return
     */

}
