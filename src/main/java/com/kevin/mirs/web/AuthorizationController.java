package com.kevin.mirs.web;


import com.google.code.kaptcha.Constants;
import com.kevin.mirs.dto.MIRSResult;
import com.kevin.mirs.entity.User;
import com.kevin.mirs.service.UserService;
import com.kevin.mirs.utils.FormatUtils;
import com.kevin.mirs.utils.IPUtils;
import com.kevin.mirs.vo.LoginInfo;
import com.kevin.mirs.vo.LoginUser;
import com.kevin.mirs.vo.RegisterInfo;
import com.kevin.mirs.vo.RegisterUser;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @ApiOperation(value = "/token", notes = "登录，返回用户一个Token")
    public MIRSResult<LoginInfo> doLogin(@RequestBody LoginUser loginUser,
                                         HttpServletRequest request) {
//        Subject currentUser = SecurityUtils.getSubject();
//
//        // 如果已经登录，则转入登录成功的页面，防止继续登录
//        if (currentUser.isAuthenticated()) {
//            return "";
//        }
        System.out.println(loginUser);
        int vaild = 0;
        String original = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (!loginUser.getCaptcha().equals(original)) {
            return new MIRSResult<>(false, "验证码错误！");
        }
        if (FormatUtils.emailFormat(loginUser.getUsername())) {
            vaild = userService.checkPasswordByUserEmail(loginUser.getUsername(), loginUser.getPassword());
        } else {
            vaild = userService.checkPasswordByUsername(loginUser.getUsername(), loginUser.getPassword());
        }
        if (vaild == 1) {
            String token = "";
            LoginInfo loginInfo = new LoginInfo(loginUser.getUsername(), token);
            return new MIRSResult<>(true, loginInfo);
        } else {
            return new MIRSResult<>(false, "用户名或密码错误！");
        }

    }

    @ResponseBody
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ApiOperation(value = "/account", notes = "注册一个账号")
    public MIRSResult<RegisterInfo> doRegister(@RequestBody RegisterUser registerUser,
                                               HttpServletRequest request) {

        String ip = IPUtils.getIpAddr(request);

        // TODO 验证验证码


        System.out.println(registerUser);

        User user = userService.addUer(
                registerUser.getUsername(),
                registerUser.getPassword(),
                registerUser.getEmail(),
                registerUser.getVerification(),
                ip);

        if (user != null) {
            // TODO 增加token
            RegisterInfo registerInfo = new RegisterInfo(user.getUsername(),
                    user.getEmail(), "", user.getRegisterTime(), user.getRegisterIp());
            System.out.println(registerInfo);
            return new MIRSResult<>(true, registerInfo);
        } else {
            return new MIRSResult<>(false, "注册失败！");
        }
    }

}
