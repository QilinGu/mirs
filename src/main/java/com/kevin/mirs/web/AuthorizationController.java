package com.kevin.mirs.web;


import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @ApiOperation(value = "/token", notes = "登录，返回用户一个Token")
    public String doLogin(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "captcha") String captcha) {
//        Subject currentUser = SecurityUtils.getSubject();
//
//        // 如果已经登录，则转入登录成功的页面，防止继续登录
//        if (currentUser.isAuthenticated()) {
//            return "";
//        }
        


        return "";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ApiOperation(value = "/account", notes = "注册一个账号")
    public String doRegister(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "verification") String verification) {

        return "";
    }

}
