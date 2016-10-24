package com.kevin.oauth.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.kevin.mirs.entity.OAuthUser;
import com.kevin.mirs.entity.User;
import com.kevin.oauth.config.OAuthTypes;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class SinaWeiboOAuthService extends OAuthServiceDecorator {

    private static final String PROTECTED_RESOURCE_URL = "https://api.weibo.com/oauth2/get_token_info";

    public SinaWeiboOAuthService(OAuthService oAuthService) {
        super(oAuthService, OAuthTypes.SINA_WEIBO);
    }

    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
        //TODO
        oAuthUser.setoAuthId(JSONPath.eval(JSON.parse(response.getBody()), "$.uid").toString());
        oAuthUser.setUser(new User());
        return oAuthUser;
    }

}