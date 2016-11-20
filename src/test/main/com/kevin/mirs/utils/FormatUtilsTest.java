package com.kevin.mirs.utils;

import org.junit.Test;

import static org.junit.Assert.*;


public class FormatUtilsTest {
    @Test
    public void emailFormat() throws Exception {

        System.out.println(FormatUtils.emailFormat("1@q5.com"));
        System.out.println(FormatUtils.emailFormat("1q.com"));
        System.out.println(FormatUtils.emailFormat("1@3.com"));
        System.out.println(FormatUtils.emailFormat("a@sd.m"));
    }

}