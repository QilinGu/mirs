package com.kevin.mirs.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@Service
public class SockJSHandler implements HandshakeHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final ArrayList<HttpSession> users = new ArrayList<HttpSession>();

    @Override
    public boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> map) throws HandshakeFailureException {
        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
        HttpSession session = servletRequest.getServletRequest().getSession();
        users.add(session);
        System.out.println(session);
        return true;
    }


}
