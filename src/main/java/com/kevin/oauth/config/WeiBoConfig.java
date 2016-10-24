package com.kevin.oauth.config;


import com.kevin.oauth.service.OAuthServiceDecorator;
import com.kevin.oauth.service.SinaWeiboOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.SinaWeiboApi20;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeiBoConfig {

    private static final String CALLBACK_URL = "%s/oauth/%s/callback";

    String sinaAppKey = "32434523";
    String sinaAppSecret = "sdfhgfhrtyhdfga";
    String host = "http://localhost:8080";

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
