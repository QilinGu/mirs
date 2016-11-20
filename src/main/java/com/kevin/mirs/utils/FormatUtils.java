package com.kevin.mirs.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatUtils {

    public static boolean emailFormat(String email)
    {
        boolean tag = true;
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }

}
