package com.vampire.xpostdeom.hook.pac;/**
 * Created by tarena on 2017/1/5.
 */


import com.google.gson.Gson;

/**
 * created by Vampire
 * on: 2017/1/5 下午3:26
 * hook.InitInterfaceB.InitInterface
 */
public class GsonTool {
    private static final String TAG = "GsonTool-vampire";

    // a
    public static <T> T ghost(String s, Class<T> tClass) {
        return new Gson().fromJson(s, tClass);
    };
}
