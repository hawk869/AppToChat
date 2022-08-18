package com.danielcepeda.backendchat.service;

import com.danielcepeda.backendchat.models.Message;
import com.danielcepeda.backendchat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository repository;

    @Override
    public List<Message> getLast10Messages() {
        return repository.findFirstOrOrderByDate();
    }

    @Override
    public Message saveMessage(Message message) {
        return repository.save(message);
    }
}
