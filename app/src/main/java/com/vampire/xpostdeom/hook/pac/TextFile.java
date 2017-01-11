package com.vampire.xpostdeom.hook.pac;/**
 * Created by tarena on 2017/1/5.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by Vampire
 * on: 2017/1/5 下午2:36
 * hook.InitInterfaceB.InitInterfaceB
 */
public class TextFile {
    private static final String TAG = "TextFile-vampire";

    public static String string(String filePath) throws IOException {
        String string = "";
        File file = new File(filePath);
        if (file.isDirectory()) {
            Log.d(TAG, "the file doesn't  exist");
            filePath = string;
        } else {
            String s = string;
            String s2 = string;
            FileInputStream inputStream = new FileInputStream(file);
            filePath = string;
            if (inputStream != null) {
                s = string;
                s2 = string;
                filePath = string;
                s = string;
                s2 = string;
                filePath = string;
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                s = string;
                s2 = string;
                filePath = string;
                s = string;
                s2 = string;
                filePath = string;
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    s = string;
                    s2 = string;
                    filePath = string;
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    s = string;
                    s2 = string;
                    filePath = string;
                    s = string;
                    s2 = string;
                    filePath = string;
                    StringBuilder stringBuilder = new StringBuilder();
                    s = string;
                    s2 = string;
                    filePath = string;
                    string = stringBuilder.append(string).append(line).append("\n").toString();
                }
                s = string;
                s2 = string;
                filePath = string;
                inputStream.close();
                s = string;
                s2 = string;
                filePath = string;
                filePath = DoFile.vampire("0123456789ABCDEF", string);
            }
        }
        return filePath;
    }
}
