package com.kevin.oauth.service;


import com.kevin.oauth.config.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OAuthServices {

    @Resource
    GitHubConfig gitHubConfig;

    @Resource
    QQConfig qqConfig;

    @Resource
    WeiXinConfig weiXinConfig;

    @Resource
    WeiBoConfig weiBoConfig;


    public CustomOAuthService getoAuthServiceByType(String type) {
        if(OAuthTypes.GITHUB.equals(type)){
            return gitHubConfig.getGithubOAuthService();
        }else if(OAuthTypes.QQ.equals(type)) {
            return qqConfig.getQQOAuthService();
        }else if (OAuthTypes.WEIXIN.equals(type)) {
            return weiXinConfig.getWeixinOAuthService();
        }else if (OAuthTypes.SINA_WEIBO.equals(type)) {
            return weiBoConfig.getSinaOAuthService();
        }else {
            return null;
        }
    }
}
