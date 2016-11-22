package com.kevin.mirs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public void sendEmail (@RequestParam(value = "email") String  email) {

        // 验证邮箱格式

        // 验证是否注册

        // 创建注册会话

        // 发送邮件

    }

}
