package com.danielcepeda.backendchat.service;

import com.danielcepeda.backendchat.models.Message;

import java.util.List;

public interface ChatService {

    public List<Message> getLast10Messages();
    public Message saveMessage(Message message);
}
