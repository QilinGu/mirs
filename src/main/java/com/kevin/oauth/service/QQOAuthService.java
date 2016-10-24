package com.kevin.oauth.service;


import com.kevin.mirs.entity.OAuthUser;
import com.kevin.mirs.entity.User;
import com.kevin.oauth.config.OAuthTypes;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class QQOAuthService extends OAuthServiceDecorator {

    private static final String PROTECTED_RESOURCE_URL = "https://graph.qq.com/oauth2.0/me";

    public QQOAuthService(OAuthService oAuthService) {
        super(oAuthService, OAuthTypes.QQ);
    }

    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
        //TODO
        oAuthUser.setoAuthId(response.getBody());
        oAuthUser.setUser(new User());
        return oAuthUser;
    }
}
