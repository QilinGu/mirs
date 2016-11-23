package com.kevin.mirs.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class EmailService {

    private static final String SUBJECT = "来自电影智能推荐系统的邮件";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private JavaMailSenderImpl sender;

    // TODO: 2016/11/23 按照不同的邮件类型封装不同的方法：注册，找回密码等

    public boolean sendVerificationEmail(String sendTo, String verification) {

        logger.info("--------------------sendVerificationEmail:" + sendTo + "--------------------");

        // 构建简单邮件对象，见名知意
        SimpleMailMessage smm = new SimpleMailMessage();
        // 设定邮件参数
        smm.setFrom(sender.getUsername());
        smm.setTo(sendTo);
        smm.setSubject(SUBJECT);
        smm.setText("您的验证码是：" + verification);

        try {
            sender.send(smm);
        } catch (MailSendException e) {
            e.printStackTrace();
            logger.info("--------------------sendVerificationEmail failed--------------------");

            return false;
        }
        logger.info("--------------------sendVerificationEmail:" + sendTo + " succeed--------------------");
        return true;
    }

}
