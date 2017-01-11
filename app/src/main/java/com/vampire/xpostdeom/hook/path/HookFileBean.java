package com.vampire.xpostdeom.hook.path;/**
 * Created by tarena on 2017/1/5.
 */

import android.os.Environment;

/**
 * created by Vampire
 * on: 2017/1/5 下午2:30
 * hook.a.InitInterfaceB
 */
public class HookFileBean {
    private static final String TAG = "HookFileBean-vampire";
    public static String directoryPath;
    public static String filePath;

    static {
        directoryPath = null;
        filePath = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            directoryPath = Environment.getExternalStorageDirectory().toString();
            filePath = directoryPath + "/wcar";
        }
    }
}
