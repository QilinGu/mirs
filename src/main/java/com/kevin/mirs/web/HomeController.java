package com.kevin.mirs.web;

import com.kevin.mirs.dao.EmailVerifyDao;
import com.kevin.mirs.dao.RegisterSessionDao;
import com.kevin.mirs.enums.EVChannelEnum;
import com.kevin.mirs.enums.EVTypeEnum;
import com.kevin.mirs.service.EmailService;
import com.kevin.mirs.service.UserService;
import com.kevin.mirs.utils.EncryptionUtils;
import com.kevin.mirs.utils.FormatUtils;
import com.kevin.mirs.utils.IPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;


@Controller
public class HomeController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserService userService;

    @Resource
    EmailService emailService;

    @Resource
    RegisterSessionDao RSDao;

    @Resource
    EmailVerifyDao EVDao;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Restful services is up!";
    }
//
//    @RequestMapping(value = "/success", method = RequestMethod.GET)
//    public String success() {
//        return "success";
//    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public void sendEmail (@RequestParam(value = "email") String  email,
                           HttpServletRequest request) {
        logger.info("--------------------POST:/email--------------------");

        // 验证邮箱格式
        if(FormatUtils.emailFormat(email) == false) {
            return;
        }

        // 验证是否注册
        if(userService.checkEmailRegistered(email) == 1) {
            return;
        }

        // 创建注册会话
        Date now = new Date();
        Timestamp createTime = new Timestamp(now.getTime());
        Timestamp expireTime = new Timestamp(now.getTime() + UserService.EXPIRED_TIME);
        String ip = IPUtils.getIpAddr(request);
        String verification = EncryptionUtils.getVerification();

        // 设置验证码SESSION
        request.getSession().setAttribute(UserService.VERIFICATION, verification);

        RSDao.add(createTime, email, ip, expireTime);
        EVDao.add(email, createTime, expireTime, EVChannelEnum.WEB.getChannel(),verification, EVTypeEnum.REG.getType(), ip);

        // 发送邮件
        emailService.sendVerificationEmail(email, verification);

    }

}
