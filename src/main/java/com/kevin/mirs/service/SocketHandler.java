package com.kevin.mirs.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class SocketHandler implements WebSocketHandler{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        logger.info("成功建立socket连接");
        users.add(session);
        String id = session.getAttributes().get("id").toString();
        if(id != null){
            session.sendMessage(new TextMessage("我们已经成功建立soket通信了"));
        }

    }

    @Override
    public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> arg1)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable error)
            throws Exception {
        if(session.isOpen()){
            session.close();
        }
        logger.error("连接出现错误:"+error.toString());
        users.remove(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1)
            throws Exception {
        logger.debug("连接已关闭");
        users.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param id
     * @param message
     */
    public void sendMessageToUser(String id, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get("id").equals(id)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }


}
