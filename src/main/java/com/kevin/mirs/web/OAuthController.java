package com.kevin.mirs.web;

import com.kevin.mirs.vo.Url;
import com.kevin.mirs.dto.MIRSResult;
import com.kevin.mirs.entity.OAuthUser;
import com.kevin.oauth.service.CustomOAuthService;
import com.kevin.oauth.service.OAuthServices;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oauth")
@Api(value = "/oauth", description = "第三方授权认证相关的接口")
public class OAuthController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    OAuthServices oAuthServices;

    @ResponseBody
    @RequestMapping(value = "/{type}",
            method = RequestMethod.POST)
    @ApiOperation(value = "{type}", notes = "用于获得第三方授权认证的URL")
    public MIRSResult<Url> oAuthUrl(@PathVariable(value = "type") String type) {
        logger.info("--------------------POST:/oauth/" + type + "--------------------");

        CustomOAuthService oAuthService = oAuthServices.getoAuthServiceByType(type);

        if (oAuthService != null) {
            return new MIRSResult<Url>(true, new Url(oAuthService.getAuthorizationUrl()));
        } else {
            return new MIRSResult<Url>(false, "没有此认证方式！");
        }

    }


    @RequestMapping(value = "/{type}/callback", method = RequestMethod.GET)
    @ApiIgnore
    public String oAuthCallback(@RequestParam(value = "code", required = true) String code,
                                @PathVariable(value = "type") String type) {

        logger.info("--------------------GET:/oauth/" + type + "/callback--------------------");

        CustomOAuthService oAuthService = oAuthServices.getoAuthServiceByType(type);
        Token accessToken = oAuthService.getAccessToken(null, new Verifier(code));
        OAuthUser oAuthInfo = oAuthService.getOAuthUser(accessToken);
        //判断用户是否已经注册，如果没有，则重定向到注册界面，否则，返回登录成功的界面
//        OAuthUser oAuthUser = oauthUserRepository.findByOAuthTypeAndOAuthId(oAuthInfo.getoAuthType(), oAuthInfo.getoAuthId());
//        if(oAuthUser == null){
//            model.addAttribute("oAuthInfo", oAuthInfo);
//            return "register";
//        }
//        request.getSession().setAttribute("oauthUser", oAuthUser);
//        return "redirect:/success";
//        return new MIRSResult<OAuthUser>(true, oAuthInfo);
        return "success";
    }


}
