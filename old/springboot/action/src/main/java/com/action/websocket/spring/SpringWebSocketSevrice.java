package com.action.websocket.spring;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/ws/{sid}")
@Component
public class SpringWebSocketSevrice {

    private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();
//    private static CopyOnWriteArraySet<Session> livingSessions = new CopyOnWriteArraySet<Session>();


    /**
     * 建立连接的回调方法
     *
     * @param session 与客户端的WebSocket连接会话
     * @param sid 用户id，WebSocket支持路径参数
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        livingSessions.put(session.getId(), session);
        sendMessageToAll(sid + " 加入聊天室");
    }

    /**
     * 收到客户端消息的回调方法
     *
     * @param message 客户端传过来的消息
     * @param session 对应的session
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("sid") String sid) {
        sendMessageToAll(sid + " : " + message);
    }


    /**
     * 发生错误的回调方法
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 关闭连接的回调方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("sid") String sid) {
        livingSessions.remove(session.getId());
        sendMessageToAll(sid + "退出");
    }


    /**
     * 单独发送消息
     *
     * @param session
     * @param message
     */
    public void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     *
     * @param message
     */
    public void sendMessageToAll(String message) {
        livingSessions.forEach((sessionId, session) -> {
            sendMessage(session, message);
        });
    }
}
