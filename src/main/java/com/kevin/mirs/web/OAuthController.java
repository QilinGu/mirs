package com.kevin.mirs.web;

import com.kevin.mirs.common.Url;
import com.kevin.mirs.dto.MIRSResult;
import com.kevin.mirs.entity.OAuthUser;
import com.kevin.oauth.service.CustomOAuthService;
import com.kevin.oauth.service.OAuthServices;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oauth")
public class OAuthController {

    @Resource
    OAuthServices oAuthServices;

    @ResponseBody
    @RequestMapping(value = "/{type}",
            method = RequestMethod.POST)
    public MIRSResult<Url> getGitHubOAuthUrl(@PathVariable(value = "type") String type) {

        System.out.println(type);

        CustomOAuthService oAuthService = oAuthServices.getoAuthServiceByType(type);

        if(oAuthService != null) {
            return new MIRSResult<Url>(true, new Url(oAuthService.getAuthorizationUrl()));
        } else {
            return new MIRSResult<Url>(false, "没有此认证方式！");
        }

    }


    @RequestMapping(value = "/{type}/callback", method = RequestMethod.GET)
    public String gitHubCallback(@RequestParam(value = "code", required = true) String code,
                                 @PathVariable(value = "type") String type) {

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
        return "redirect:/success";
    }


}
