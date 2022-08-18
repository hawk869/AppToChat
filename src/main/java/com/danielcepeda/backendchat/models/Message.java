package com.danielcepeda.backendchat.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter @Setter
@Document(collation = "messages")
public class Message implements Serializable {

    @Id
    private String id;
    private String text;
    private Long date;
    private String username;
    private String type;
    private String color;

    private static final long serialVersionUID = -123124253L;
}
