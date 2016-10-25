package com.kevin.mirs.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {

        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String setRegisterInfo() {

        return "redirect:/";
    }

    /**
     * 账号和用户有些微区别，登录后的用户可以看得自己账号的完全信息
     * 然而只能看到别的用户设置为公开的信息
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile() {

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

    @RequestMapping(value = "/password",method = RequestMethod.GET)
    public String editPassword() {

        return "newpage";
    }

    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    public String updatePassword() {

        //返回更新状态
        return "";
    }

    @RequestMapping(value = "forgetpassword", method = RequestMethod.GET)
    public String forgetPassword() {

        return "";
    }

    @RequestMapping(value = "resetpassword", method = RequestMethod.POST)
    public String resetPassword() {

        return "";
    }

}
