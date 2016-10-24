package com.kevin.oauth.service;


import com.kevin.mirs.entity.OAuthUser;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Service;

@Service
public interface CustomOAuthService extends OAuthService{

    String getoAuthType();
    String getAuthorizationUrl();
    OAuthUser getOAuthUser(Token accessToken);

}
