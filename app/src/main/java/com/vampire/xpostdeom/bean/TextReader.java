package com.vampire.xpostdeom.bean;/**
 * Created by tarena on 2017/1/6.
 */

/**
 * created by Vampire
 * on: 2017/1/6 下午2:19
 */
public class TextReader {
    private static final String TAG = "TextReader-vampire";
    private String string;

    public TextReader(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
