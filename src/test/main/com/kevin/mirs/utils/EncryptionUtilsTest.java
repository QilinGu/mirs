package com.kevin.mirs.utils;

import org.junit.Test;

import static org.junit.Assert.*;


public class EncryptionUtilsTest {
    @Test
    public void SHA512Encode() throws Exception {

        System.out.println(EncryptionUtils.SHA512Encode("234", "23"));
    }

}