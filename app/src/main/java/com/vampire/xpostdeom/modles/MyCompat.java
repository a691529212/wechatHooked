package com.vampire.xpostdeom.modles;/**
 * Created by tarena on 2017/1/5.
 */

import android.widget.CompoundButton;

import com.vampire.xpostdeom.MainActivity;

/**
 * created by Vampire
 * on: 2017/1/5 上午10:02
 */
public class MyCompat implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "MyCompat-vampire";
    MainActivity mainActivity;

    public MyCompat(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        this.mainActivity.settingHelper.setBoolean("open", b);

    }
}
