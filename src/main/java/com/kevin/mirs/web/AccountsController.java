package com.kevin.mirs.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {

        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String setRegisterInfo(@RequestParam(value = "userName") String userName,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "userEmail") String userEmail,
                                  @RequestParam(value = "verification") String verification) {

        return "redirect:/";
    }

    /**
     * 账号和用户有些微区别，登录后的用户可以看得自己账号的完全信息
     * 然而只能看到别的用户设置为公开的信息
     * @return
     */
    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public String getProfile(@PathVariable(value = "userId") String userId) {

        return "";
    }

    /**
     * TODO 考虑是全部信息一起提交还是分别提交
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.PATCH)
    public String setProfile() {

        return "";
    }

    @RequestMapping(value = "/password/{userId}",method = RequestMethod.GET)
    public String editPassword(@PathVariable(value = "userId") String userId) {

        return "newpage";
    }

    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    public String updatePassword(@RequestParam(value = "userEmail") String userEmail,
                                 @RequestParam(value = "password") String password) {

        //返回更新状态
        return "";
    }

    @RequestMapping(value = "forget-password", method = RequestMethod.GET)
    public String forgetPassword() {

        return "";
    }

    @RequestMapping(value = "reset-password", method = RequestMethod.POST)
    public String resetPassword(@RequestParam(value = "userEmail") String userEmail,
                                @RequestParam(value = "password") String password,
                                @RequestParam(value = "verification") String verification) {

        return "";
    }

}
