package com.vampire.xpostdeom.hook.path;/**
 * Created by tarena on 2017/1/1.
 */

import android.content.Context;
import android.content.SharedPreferences;

import de.robv.android.xposed.XSharedPreferences;

/**
 * created by Vampire
 * on: 2017/1/1 下午3:54
 * hook.a.a
 */
public class XPosedSettingHelper {
    private SharedPreferences sharedPreferences = null; //sp
    private XSharedPreferences xSharedPreferences = null; // XposedSp

    // 传入包名  模块的
    public XPosedSettingHelper(String packageName) {
        xSharedPreferences = new XSharedPreferences(packageName);
        xSharedPreferences.makeWorldReadable();
        this.reload();

    }

    public XPosedSettingHelper(Context context, String packageName) {
        this.sharedPreferences = null;
        this.xSharedPreferences = null;
        this.sharedPreferences = context.getSharedPreferences(packageName + "_preferences", 1);

    }

    public String getString(String key, String defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, defaultValue);
        } else if (xSharedPreferences != null) {
            return xSharedPreferences.getString(key, defaultValue);
        }
        return defaultValue;
    }

    public int getInt(String key, int defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(key, defaultValue);
        } else if (xSharedPreferences != null) {
            return xSharedPreferences.getInt(key, defaultValue);
        }

        return defaultValue;
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor editor = null;
        if (sharedPreferences != null) {
            editor = sharedPreferences.edit();
        } else if (xSharedPreferences != null) {
            editor = xSharedPreferences.edit();
        }

        if (editor != null) {
            editor.putString(key, value);
            editor.commit();
        }
    }

    public void setInt(String key, int value) {
        SharedPreferences.Editor editor = null;
        if (sharedPreferences != null) {
            editor = sharedPreferences.edit();
        } else if (xSharedPreferences != null) {
            editor = xSharedPreferences.edit();
        }

        if (editor != null) {
            editor.putInt(key, value);
            editor.commit();
        }
    }

    public void setBoolean(String key, boolean b) {
        SharedPreferences.Editor editor = null;
        if (sharedPreferences != null) {
            editor = this.sharedPreferences.edit();
        } else if (this.xSharedPreferences != null) {
            editor = this.xSharedPreferences.edit();
        }
        if (editor != null) {
            editor.putBoolean(key, b);
            editor.commit();
        }
    }

    public boolean getBoolean(String key, boolean defaultBoolean) {
        boolean b;
        if (this.sharedPreferences != null) {
            b = this.sharedPreferences.getBoolean(key, defaultBoolean);
        } else {
            b = defaultBoolean;
            if (this.xSharedPreferences != null) {
                b = this.xSharedPreferences.getBoolean(key, defaultBoolean);
            }
        }
        return b;
    }


    public void reload() {
        if (xSharedPreferences != null) {
            xSharedPreferences.reload();
        }
    }
}
