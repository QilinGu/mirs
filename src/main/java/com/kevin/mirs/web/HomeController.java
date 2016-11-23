package com.kevin.mirs.web;

import com.kevin.mirs.dao.EmailVerifyDao;
import com.kevin.mirs.dao.RegisterSessionDao;
import com.kevin.mirs.dto.MIRSResult;
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

    @ResponseBody
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public MIRSResult<Boolean> sendEmail (@RequestParam(value = "email") String  email,
                                          HttpServletRequest request) {
        logger.info("--------------------POST:/email--------------------");

        // TODO: 2016/11/23 考虑如何保证接口安全，不被恶意利用。比如加上验证码 

        // 验证邮箱格式
        if(FormatUtils.emailFormat(email) == false) {
            return new MIRSResult<Boolean>(false, "邮件格式不正确!");
        }

        // 验证是否注册
        if(userService.checkEmailRegistered(email) == 1) {
            return new MIRSResult<Boolean>(false, "此邮箱已被注册!");
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
        if (!emailService.sendVerificationEmail(email, verification)) {
            return new MIRSResult<Boolean>(false, "系统内部错误!");
        }
        return new MIRSResult<Boolean>(true, true);
    }

}
