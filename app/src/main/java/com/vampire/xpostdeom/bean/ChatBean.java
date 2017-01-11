package com.vampire.xpostdeom.bean;/**
 * Created by tarena on 2017/1/6.
 */

/**
 * created by Vampire
 * on: 2017/1/6 上午11:52
 */
public class ChatBean {
    private static final String TAG = "ChatBean-vampire";
    String talkerID;
    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static String getTAG() {
        return TAG;
    }

    public String getTalkerID() {
        return talkerID;
    }

    public void setTalkerID(String talkerID) {
        this.talkerID = talkerID;
    }
}
