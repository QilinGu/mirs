package com.kevin.mirs.web;


import com.kevin.mirs.service.SocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;

@Controller
public class WebSocketController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    SocketHandler socketHandler;

    @MessageMapping(value = "/greeting")
    public void greet(WebSocketSession session){
        String id = session.getAttributes().get("id").toString();
        socketHandler.sendMessageToUser(id, new TextMessage("Greeting from server!"));
    }

}
