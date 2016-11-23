package com.kevin.mirs.utils;


import org.apache.shiro.crypto.hash.Sha512Hash;

import java.util.Random;

public class EncryptionUtils {

    private static final int VERIFICATION_LENGTH = 6;

    public static String getSalt(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(str.length());
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

    public static String SHA512Encode(String content, String salt) {
        return new Sha512Hash(content, salt, 100).toString();
    }

    public static String getVerification() {
        return getSalt(VERIFICATION_LENGTH);
    }

}
