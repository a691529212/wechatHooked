package com.vampire.xpostdeom.service;/**
 * Created by tarena on 2017/1/6.
 */

import android.os.FileObserver;
import android.util.Log;

import com.vampire.xpostdeom.bean.TextReader;
import com.vampire.xpostdeom.utils.FileUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * created by Vampire
 * on: 2017/1/6 下午2:02
 */
public class FileListener extends FileObserver {
    private static final String TAG = "FileListener-vampire";
    private String reader;

    public String getReader() {
        return reader;
    }

    public FileListener(String path) {
        super(path);
    }

    public FileListener(String path, int mask) {
        super(path, mask);
    }

    @Override
    public void onEvent(int i, String s) {
        switch (i) {
            case CLOSE_WRITE:
                reader = FileUtils.readFileContent("/sdcard/chatting.txt");
                Log.d(TAG, reader);
                EventBus.getDefault().post(new TextReader(reader));
                break;
        }
    }
}
