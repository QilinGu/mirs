package com.kevin.mirs.web;

import com.kevin.mirs.dto.MIRSResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/inspection")
public class InspectionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/userName/{name}", method = RequestMethod.POST)
    public MIRSResult<Boolean> inspectUserName(@PathVariable(value = "name") String name) {

        //TODO 查询数据库，判断用户名是否存在

        return new MIRSResult<Boolean>(false, "用户名已存在!");
    }

    @ResponseBody
    @RequestMapping(value = "/userEmail/{email}", method = RequestMethod.POST)
    public MIRSResult<Boolean> inspectUserEmail(@PathVariable(value = "email") String email) {

        //TODO 查询数据库，判断邮箱是否已被注册

        return new MIRSResult<Boolean>(false, "此邮箱已注册!");
    }

    @ResponseBody
    @RequestMapping(value = "/verification/{verification}", method = RequestMethod.POST)
    public MIRSResult<Boolean> inspectVerification(@PathVariable(value = "verification") String verification) {

        //TODO 查询SESSION,判断验证码是否正确

        return new MIRSResult<Boolean>(false, "验证码错误!");
    }



}
