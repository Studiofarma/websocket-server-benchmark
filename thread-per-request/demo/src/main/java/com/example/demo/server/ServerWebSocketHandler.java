package com.example.demo.server;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class ServerWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        session.setTextMessageSizeLimit(20000000);
    }

    @Override
    public void handleTextMessage(WebSocketSession callerSession, @NotNull TextMessage toForward) throws IOException {
        String content = toForward.getPayload();
        callerSession.sendMessage(new TextMessage(content));
    }
}
