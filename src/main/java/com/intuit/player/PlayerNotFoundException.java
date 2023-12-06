package com.intuit.player;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such player!")
public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String id) {
        super("player:["+id+"] not found");
    }
}
