package com.kevin.config;


import com.kevin.interceptor.WebSocketInterceptor;
import com.kevin.mirs.service.SocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;


@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Bean
    public WebSocketHandler socketHandler() {
        return new SocketHandler();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        //注册处理拦截器,拦截url为socketServer的请求
        registry.addHandler(socketHandler(), "/socketServer").addInterceptors(new WebSocketInterceptor());

        //注册SockJs的处理拦截器,拦截url为/sockjs/socketServer的请求
        registry.addHandler(socketHandler(), "/sockjs/socketServer").addInterceptors(new WebSocketInterceptor()).withSockJS();
    }

}
