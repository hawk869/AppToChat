package com.danielcepeda.backendchat.repository;

import com.danielcepeda.backendchat.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Message, String> {

    public List<Message> findFirstOrOrderByDate();
}
