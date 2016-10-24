package com.kevin.oauth.config;


import com.kevin.oauth.api.GitHubApi;
import com.kevin.oauth.service.GithubOAuthService;
import com.kevin.oauth.service.OAuthServiceDecorator;
import org.scribe.builder.ServiceBuilder;
import org.springframework.stereotype.Component;

@Component
public class GitHubConfig {

    private static final String CALLBACK_URL = "%s/oauth/%s/callback";

    String state = "1h8k68be244kxdeb2k91sdfasdfads230f40817feeekjm";
    String clientId = "200f689343da855727ed";
    String clientSecret = "be5275d9b9764cd4d9e1889ad4cf3830281b42d2";
    String host = "http://localhost:8080";


    public GitHubApi githubApi(){
        return new GitHubApi(state);
    }

    public OAuthServiceDecorator getGithubOAuthService(){
        return new GithubOAuthService(new ServiceBuilder()
                .provider(githubApi())
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(String.format(CALLBACK_URL, host, OAuthTypes.GITHUB))
                .build());
    }

}
