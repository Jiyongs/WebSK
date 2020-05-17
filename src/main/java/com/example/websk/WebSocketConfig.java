package com.example.websk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        System.out.println("WebSocketConfig.class : serverEndpointExporter() 호출");
        return new ServerEndpointExporter();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        System.out.println("WebSocketConfig.class : configureMessageBroker() 호출");
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        System.out.println("WebSocketConfig.class : registerStompEndpoints() 호출");
        registry.addEndpoint("/websocket").withSockJS();
    }
}