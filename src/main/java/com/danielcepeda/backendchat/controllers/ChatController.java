package com.danielcepeda.backendchat.controllers;

import com.danielcepeda.backendchat.models.Message;
import com.danielcepeda.backendchat.service.ChatService;
import com.danielcepeda.backendchat.service.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

@Controller
public class ChatController {

    private final String[] colors = {"red", "blue", "yellow", "green", "magenta", "orange"};

    @Autowired
    private ChatServiceImpl service;

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message){
        message.setDate(new Date().getTime());
        if (message.getType().equals("NEW_USER")){
            message.setColor(colors[new Random().nextInt(colors.length)]);
            message.setText("new_user connected");
        }else{
            service.saveMessage(message);
        }
        return message;
    }
    @MessageMapping("/writting")
    @SendTo("/chat/writting")
    public String isWritting(String username){
        return username.concat(" is writting");
    }
    @MessageMapping("/record")
    public void getRecords(String clientId){
        template.convertAndSend("/chat/record/" + clientId, service.getLast10Messages());
    }
}
