package com.kevin.mirs.web;

import com.kevin.mirs.dto.MIRSResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/inspection")
public class InspectionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/userName", method = RequestMethod.POST)
    public MIRSResult<Boolean> inspectUserName(@RequestParam(value = "name") String name) {

        //TODO 查询数据库，判断用户名是否存在

        return new MIRSResult<Boolean>(false, "用户名已存在!");
    }

    @ResponseBody
    @RequestMapping(value = "/userEmail", method = RequestMethod.POST)
    public MIRSResult<Boolean> inspectUserEmail(@RequestParam(value = "email") String email) {

        //TODO 查询数据库，判断邮箱是否已被注册

        return new MIRSResult<Boolean>(false, "此邮箱已注册!");
    }

    @ResponseBody
    @RequestMapping(value = "/verification", method = RequestMethod.POST)
    public MIRSResult<Boolean> inspectVerification(@RequestParam(value = "verification") String verification) {

        //TODO 查询SESSION,判断验证码是否正确

        return new MIRSResult<Boolean>(false, "验证码错误!");
    }



}
