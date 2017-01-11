package com.vampire.xpostdeom;/**
 * Created by tarena on 2017/1/6.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * created by Vampire
 * on: 2017/1/6 下午2:49
 */
public class DoCommond {
    private static final String TAG = "DoCommond-vampire";

    /**
     * 执行一个shell命令，并返回字符串值
     *
     * @param cmd           命令名称&参数组成的数组（例如：{"/system/bin/cat", "/proc/version"}）
     * @param workdirectory 命令执行路径（例如："system/bin/"）
     * @return 执行结果组成的字符串
     * @throws IOException
     */
    public static synchronized String run(String[] cmd, String workdirectory)
            throws IOException {
        StringBuffer result = new StringBuffer();
        try {
            // 创建操作系统进程（也可以由Runtime.exec()启动）
            // Runtime runtime = Runtime.getRuntime();
            // Process proc = runtime.exec(cmd);
            // InputStream inputstream = proc.getInputStream();
            ProcessBuilder builder = new ProcessBuilder(cmd);
            InputStream in = null;
            // 设置一个路径（绝对路径了就不一定需要）
            if (workdirectory != null) {
                // 设置工作目录（同上）
                builder.directory(new File(workdirectory));
                // 合并标准错误和标准输出
                builder.redirectErrorStream(true);
                // 启动一个新进程
                Process process = builder.start();
                // 读取进程标准输出流
                in = process.getInputStream();
                byte[] re = new byte[1024];
                while (in.read(re) != -1) {
                    result = result.append(new String(re));
                }
            }
            // 关闭输入流
            if (in != null) {
                in.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result.toString();
    }

    // top命令
    public static final String[] TOP = { "am start", "-n com.tencent.mm/com.tencent.mm.ui.chatting.ChattingUI", "-e Chat_User aishiyu123" };

    public static synchronized String run(String[] cmd) {
        String line = "";
        InputStream is = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec(cmd);
            is = proc.getInputStream();
            // 换成BufferedReader
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            do {
                line = buf.readLine();
                // 前面有几个空行
                if (line.startsWith("User")) {
                    // 读到第一行时，我们再读取下一行
                    line = buf.readLine();
                    break;
                }
            } while (true);
            if (is != null) {
                buf.close();
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "e:" + e);
        }
        return line;
    }

}
