package com.example.demo.server;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ReactiveServerWebSocketHandler implements WebSocketHandler {

    @Override
    public @NotNull
    Mono<Void> handle(@NotNull WebSocketSession session) {
        return session.send(session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .map(session::textMessage)
        );
    }

    @Override
    public @NotNull
    List<String> getSubProtocols() {
        return WebSocketHandler.super.getSubProtocols();
    }
}

