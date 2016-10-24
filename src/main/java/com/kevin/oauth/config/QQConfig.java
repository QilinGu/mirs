package com.kevin.oauth.config;


import com.kevin.oauth.api.QQApi;
import com.kevin.oauth.service.OAuthServiceDecorator;
import com.kevin.oauth.service.QQOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.springframework.stereotype.Component;

@Component
public class QQConfig {

    private static final String CALLBACK_URL = "%s/oauth/%s/callback";

    String state = "state3245fg34fdge";
    String qqAppId = "1105694353";
    String qqAppKey = "XYwzErJ8SCfWx2Tz";
    String host = "http://localhost:8080";


    public QQApi qqApi(){
        return new QQApi(state);
    }


    public OAuthServiceDecorator getQQOAuthService(){
        return new QQOAuthService(new ServiceBuilder()
                .provider(qqApi())
                .apiKey(qqAppId)
                .apiSecret(qqAppKey)
                .callback(String.format(CALLBACK_URL, host,OAuthTypes.QQ))
                .build());
    }

}
