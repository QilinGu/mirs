package com.kevin.mirs.web;


import com.kevin.mirs.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation(value = "/login", notes = "返回登录页面")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "/login", notes = "执行登录操作")
    public String doLogin() {
        Subject currentUser = SecurityUtils.getSubject();

        // 如果已经登录，则转入登录成功的页面，防止继续登录
        if (currentUser.isAuthenticated()) {
            return "redirect:/success";
        }

        // 如果是 GET 则显示登录页面，
        // 如果是 POST 则进入登录逻辑处理 UserFormAuthenticationFilter.executeLogin()


        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ApiOperation(value = "/register", notes = "返回注册页面")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "/register", notes = "执行注册操作")
    public String doRegister(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "verification") String verification) {

        return "redirect:/";
    }

    /**
     * 账号和用户有些微区别，登录后的用户可以看得自己账号的完全信息
     * 然而只能看到别的用户设置为公开的信息
     *
     * @return
     */
    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "/profile/{userId}", notes = "返回用户个人信息")
    public String getProfile(@PathVariable(value = "userId") String userId) {

        return "";
    }

    /**
     * TODO 考虑是全部信息一起提交还是分别提交
     *
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.PATCH)
    @ApiOperation(value = "/profile", notes = "更新用户提交的信息")
    public String setProfile() {

        return "";
    }

    @RequestMapping(value = "/password/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "/password/{userId}", notes = "返回更改密码页面")
    public String editPassword(@PathVariable(value = "userId") String userId) {

        return "newpage";
    }

    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    @ApiOperation(value = "/password", notes = "执行更改密码操作")
    public String updatePassword(@RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password) {

        //返回更新状态
        return "";
    }

    @RequestMapping(value = "/forget-password", method = RequestMethod.GET)
    @ApiOperation(value = "/forget-password", notes = "返回忘记密码页面")
    public String forgetPassword() {

        return "";
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    @ApiOperation(value = "/reset-password", notes = "重置用户密码")
    public String resetPassword(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password,
                                @RequestParam(value = "verification") String verification) {

        return "";
    }

}
