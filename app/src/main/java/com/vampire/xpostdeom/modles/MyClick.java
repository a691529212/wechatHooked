package com.vampire.xpostdeom.modles;/**
 * Created by tarena on 2017/1/5.
 */

import android.view.View;

import com.vampire.xpostdeom.MainActivity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * created by Vampire
 * on: 2017/1/5 上午10:12
 */
public class MyClick implements View.OnClickListener {
    private static final String TAG = "MyClick-vampire";
    MainActivity mainActivity;

    public MyClick(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        this.mainActivity.posed();
        ArrayList<String>  strings = new ArrayList<>();
        Iterator<WeChatContent> weChatContentIterator = this.mainActivity.contentList.iterator();
        while (weChatContentIterator.hasNext()){
            strings.add(weChatContentIterator.next().getNickName());
        }
        // 支持
    }
}
