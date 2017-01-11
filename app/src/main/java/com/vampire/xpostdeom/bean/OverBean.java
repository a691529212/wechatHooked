package com.vampire.xpostdeom.bean;/**
 * Created by tarena on 2017/1/6.
 */

/**
 * created by Vampire
 * on: 2017/1/6 下午6:16
 */
public class OverBean {
    private static final String TAG = "OverBean-vampire";
    private boolean isOver;

    public OverBean(boolean isOver) {
        this.isOver = isOver;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }
}
