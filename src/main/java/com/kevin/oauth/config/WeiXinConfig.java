package com.kevin.oauth.config;


import com.kevin.oauth.api.WeiXinApi;
import com.kevin.oauth.service.CustomOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.springframework.stereotype.Component;

@Component
public class WeiXinConfig {
    private static final String CALLBACK_URL = "%s/oauth/%s/callback";

    String weixinAppId = "3423drfe";
    String weixinAppSecret = "dfsdfwefsdfwefsdfd";
    String host = "http://localhost:8080";


    public CustomOAuthService getWeixinOAuthService(){
        return (CustomOAuthService) new ServiceBuilder()
                .provider(WeiXinApi.class)
                .apiKey(weixinAppId)
                .apiSecret(weixinAppSecret)
                .scope("snsapi_login")
                .callback(String.format(CALLBACK_URL, host, OAuthTypes.WEIXIN))
                .build();
    }
}
