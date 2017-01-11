package com.vampire.xpostdeom.modles;/**
 * Created by tarena on 2017/1/5.
 */

/**
 * created by Vampire
 * on: 2017/1/5 上午9:21
 */
public class WeChatContent {
    private static final String TAG = "WeChatContent-vampire";
    private String nickName;
    private String userName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public static String getTAG() {
        return TAG;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
