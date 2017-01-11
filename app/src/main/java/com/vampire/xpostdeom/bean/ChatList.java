package com.vampire.xpostdeom.bean;/**
 * Created by tarena on 2017/1/6.
 */

import java.util.List;

/**
 * created by Vampire
 * on: 2017/1/6 上午11:53
 */
public class ChatList {
    private static final String TAG = "ChatList-vampire";
    private List<ChatBean> chatBeen;

    public ChatList(List<ChatBean> chatBeen) {
        this.chatBeen = chatBeen;
    }

    public List<ChatBean> getChatBeen() {
        return chatBeen;
    }

    public void setChatBeen(List<ChatBean> chatBeen) {
        this.chatBeen = chatBeen;
    }
}
