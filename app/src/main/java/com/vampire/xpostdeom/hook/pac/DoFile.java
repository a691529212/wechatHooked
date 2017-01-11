package com.vampire.xpostdeom.hook.pac;/**
 * Created by tarena on 2017/1/5.
 */

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * created by Vampire
 * on: 2017/1/5 下午2:46
 * hook.InitInterfaceB.a
 */
public class DoFile {
    private static final String TAG = "DoFile-vampire";

    public static String string(String s, String s2) throws NoSuchProviderException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        return string(string(vampire(Base64.decode(s, 0)), s2.getBytes()));
    }

    public static String string(byte[] bytes) {
        String string;
        if (bytes == null) {
            string = "";
        } else {
            StringBuffer buffer = new StringBuffer(bytes.length * 2);
            for (int i = 0; i < bytes.length; i++) {
                string(buffer, bytes[i]);
            }
            string = buffer.toString();
        }
        return string;
    }

    public static void string(StringBuffer buffer, byte b) {
        buffer.append("0123456789ABCDEF".charAt(b >> 4 & 0xF)).append("0123456789ABCDEF".charAt(b & 0XF));
    }

    public static byte[] string(String s) {
        int n = s.length() / 2;
        byte[] bytes = new byte[n];
        for (int i = 0; i < n; i++) {
            bytes[i] = (byte) (Object) Integer.valueOf(s.substring(i * 2, i * 2 + 2), 16);
        }
        return bytes;

    }

    public static byte[] string(byte[] bytes, byte[] bytes2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bytes2);
    }

    public static String vampire(String s) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update((s + "ghost").getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            while (i < digest.length) {
                if (Integer.toHexString(digest[i] & 0Xff).length() == 1) {
                    stringBuffer.append("0").append(Integer.toHexString(digest[i] & 0xFF));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i] & 0xff));
                }
                ++i;
                // goto Label_0124;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            s = "";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            s = "";
        }
        return s;

    }

    public static String vampire(String s, String s2) {
        return new String(vampire(vampire(String.valueOf(Base64.decode(s, 0))), String.valueOf(string(s2))));
    }

    @SuppressLint({"TrulyRandom"})
    private static byte[] vampire(byte[] seed) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom;
        if (Build.VERSION.SDK_INT >= 17) {
            secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        } else {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        }
        secureRandom.setSeed(seed);
        instance.init(256, secureRandom);
        return instance.generateKey().getEncoded();
    }

    private static byte[] vampire(byte[] bytes, byte[] bytes2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bytes2);

    }


}
