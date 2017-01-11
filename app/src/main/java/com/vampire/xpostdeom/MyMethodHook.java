package com.vampire.xpostdeom;/**
 * Created by tarena on 2017/1/4.
 */

import android.content.Context;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * created by Vampire
 * on: 2017/1/4 下午6:18
 */
public class MyMethodHook extends XC_MethodHook {
    private static final String TAG = "MyMethodHook-vampire";
    private Context context;
    private String pName;
    private String vName;
    private XC_LoadPackage.LoadPackageParam param;
    private HookDeom hookDeom;

    public MyMethodHook(Context context, HookDeom hookDeom, XC_LoadPackage.LoadPackageParam param, String vName, String pName) {

        this.context = context;
        this.hookDeom = hookDeom;
        this.param = param;
        this.vName = vName;
        this.pName = pName;
    }

    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        //(Context) param.thisObject
        int uid = this.param.appInfo.uid;
        HookHelper access$000 = this.hookDeom.getHooks(context, (Context) param.thisObject, pName, vName,uid);
        if (access$000 != null){
//            access$000.init(this.getClass().getClassLoader());
            access$000.hook(this.param.classLoader);
        }
    }
}
