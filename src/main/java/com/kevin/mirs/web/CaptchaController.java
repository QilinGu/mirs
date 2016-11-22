package com.kevin.mirs.web;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.kevin.mirs.dto.MIRSResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping(value = "/captcha")
@Api(value = "/captcha", description = "验证码相关的接口")
public class CaptchaController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Producer captchaProducer;

    /**
     * 生成带验证码的图片
     *
     * @param request
     * @param response
     * @return 验证码
     * @throws IOException
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "生成带验证码的图片")
    public ModelAndView getCaptchaImage(HttpServletRequest request,
                                        HttpServletResponse response) throws IOException {
        logger.info("--------------------GET:/captcha--------------------");


        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();

        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        logger.info("======生成了一个验证码，内容为：" + capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "检测输入的验证码是否正确")
    public MIRSResult<Boolean> checkCaptchaImage(@RequestParam(value = "captcha") String captcha,
                                                 HttpServletRequest request) {
        logger.info("--------------------POST:/captcha--------------------");

        String original =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        logger.info("======用户输入的验证码：" + captcha);
        logger.info("======正确的验证码：" + original);

        if(captcha.equals(original)) {
            return new MIRSResult<Boolean>(true, true);
        }

        return new MIRSResult<Boolean>(false, "验证码不正确！");
    }


}
