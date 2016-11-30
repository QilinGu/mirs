package com.kevin.mirs.web;


import com.kevin.mirs.entity.User;
import com.kevin.mirs.service.UserService;
import com.kevin.mirs.vo.UserProfile;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserService userService;


    /**
     * 账号和用户有些微区别，登录后的用户可以看得自己账号的完全信息
     * 然而只能看到别的用户设置为公开的信息
     *
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ApiOperation(value = "/profile", notes = "返回用户个人信息")
    public UserProfile getProfile(HttpServletRequest request) {
        logger.info("--------------------GET:/accounts/profile--------------------");

        int id = (int) request.getSession().getAttribute(UserService.USER_ID);

        return null;
    }

    /**
     * TODO 考虑是全部信息一起提交还是分别提交
     *
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ApiOperation(value = "/profile", notes = "更新用户提交的信息")
    public String setProfile() {
        logger.info("--------------------POST:/accounts/profile--------------------");

        return "";
    }


    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ApiOperation(value = "/password", notes = "执行更改密码操作")
    public String updatePassword(@RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password) {
        logger.info("--------------------POST:/accounts/password--------------------");

        //返回更新状态
        return "";
    }


    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    @ApiOperation(value = "/reset-password", notes = "重置用户密码")
    public String resetPassword(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password,
                                @RequestParam(value = "verification") String verification) {
        logger.info("--------------------POST:/accounts/reset-password--------------------");

        return "";
    }

}
