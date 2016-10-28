package com.kevin.oauth.config;


import com.kevin.oauth.service.OAuthServiceDecorator;
import com.kevin.oauth.service.SinaWeiboOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.SinaWeiboApi20;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeiBoConfig {

    @Value("${oAuth.callbackUrl}") String CALLBACK_URL;
    @Value("${oAuth.host}") String host;

    @Value("${oAuth.weibo.appkey}") String sinaAppKey;
    @Value("${oAuth.weibo.appSecret}") String sinaAppSecret;


    @Bean
    public OAuthServiceDecorator getSinaOAuthService(){
        return new SinaWeiboOAuthService(new ServiceBuilder()
                .provider(SinaWeiboApi20.class)
                .apiKey(sinaAppKey)
                .apiSecret(sinaAppSecret)
                .callback(String.format(CALLBACK_URL, host, OAuthTypes.SINA_WEIBO))
                .build());
    }

}
