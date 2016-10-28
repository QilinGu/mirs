package com.kevin.oauth.config;


import com.kevin.oauth.api.QQApi;
import com.kevin.oauth.service.OAuthServiceDecorator;
import com.kevin.oauth.service.QQOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QQConfig {

    @Value("${oAuth.callbackUrl}") String CALLBACK_URL;
    @Value("${oAuth.host}") String host;
    @Value("${oAuth.qq.state}") String state;
    @Value("${oAuth.qq.appId}") String qqAppId;
    @Value("${oAuth.qq.appKey}") String qqAppKey;



    @Bean
    public QQApi qqApi(){
        return new QQApi(state);
    }


    @Bean
    public OAuthServiceDecorator getQQOAuthService(){
        return new QQOAuthService(new ServiceBuilder()
                .provider(qqApi())
                .apiKey(qqAppId)
                .apiSecret(qqAppKey)
                .callback(String.format(CALLBACK_URL, host,OAuthTypes.QQ))
                .build());
    }

}
