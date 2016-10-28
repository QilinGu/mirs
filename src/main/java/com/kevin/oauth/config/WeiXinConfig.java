package com.kevin.oauth.config;


import com.kevin.oauth.api.WeiXinApi;
import com.kevin.oauth.service.CustomOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeiXinConfig {

    @Value("${oAuth.callbackUrl}") String CALLBACK_URL;
    @Value("${oAuth.host}") String host;

    @Value("${oAuth.weixin.appId}") String weixinAppId;
    @Value("${oAuth.weixin.appSecret}") String weixinAppSecret;


    @Bean
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
