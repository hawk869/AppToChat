package com.danielcepeda.backendchat.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class Message implements Serializable {

    private String text;
    private Long date;

    private static final long serialVersionUID = -123124253L;
}
