package com.kevin.mirs.web;


import com.kevin.mirs.dto.MIRSResult;
import com.kevin.mirs.entity.User;
import com.kevin.mirs.service.UserService;
import com.kevin.mirs.utils.IPUtils;
import com.kevin.mirs.vo.RegisterInfo;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ApiOperation(value = "/account", notes = "注册一个账号")
    public MIRSResult<RegisterInfo> doRegister(@RequestParam(value = "username") String username,
                                               @RequestParam(value = "password") String password,
                                               @RequestParam(value = "email") String email,
                                               @RequestParam(value = "verification") String verification,
                                               HttpServletRequest request) {

        String ip = IPUtils.getIpAddr(request);

        User user = userService.addUer(username, password, email, verification, ip);

        if (user != null) {
            // TODO 增加token
            RegisterInfo registerInfo = new RegisterInfo(user.getUsername(),
                    user.getEmail(), "", user.getRegisterTime(), user.getRegisterIp());
            System.out.println(registerInfo);
            return new MIRSResult<RegisterInfo>(true, registerInfo);
        } else {
            return new MIRSResult<RegisterInfo>(false, "注册失败！");
        }
    }

}
