package com.kevin.mirs.service;

import com.kevin.mirs.utils.EncryptionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:junit/spring-test.xml"})
public class EmailServiceTest {

    @Resource
    EmailService emailService;

    @Test
    public void sendVerificationEmail() throws Exception {

        String to = "1351650853@qq.com";
        String verification = EncryptionUtils.getVerification();

        System.out.println(emailService.sendVerificationEmail(to, verification));

    }

}