package com.kevin.mirs.web;

import com.kevin.mirs.dto.MIRSResult;
import com.kevin.mirs.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
@RequestMapping("/inspection")
public class InspectionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/username", method = RequestMethod.POST)
    @ApiOperation(value = "/username", notes = "检查用户名是否被注册")
    public MIRSResult<Boolean> inspectUserName(@RequestParam(value = "name") String name) {

        int registered = userService.checkUsernameRegistered(name);
        if (registered == 0) {
            return new MIRSResult<Boolean>(true, true);
        } else {
            return new MIRSResult<Boolean>(false, "用户名已存在!");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/userEmail", method = RequestMethod.POST)
    @ApiOperation(value = "/userEmail", notes = "检查用户邮箱是否被注册")
    public MIRSResult<Boolean> inspectUserEmail(@RequestParam(value = "email") String email) {

        int registered = userService.checkEmailRegistered(email);
        if (registered == 0) {
            return new MIRSResult<Boolean>(true, true);
        } else {
            return new MIRSResult<Boolean>(false, "此邮箱已被注册!");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/verification", method = RequestMethod.POST)
    @ApiOperation(value = "/verification", notes = "检查用户输入的邮箱的验证码是否正确")
    public MIRSResult<Boolean> inspectVerification(@RequestParam(value = "verification") String verification) {

        //TODO 查询SESSION,判断验证码是否正确

        return new MIRSResult<Boolean>(true, true);
    }


}
