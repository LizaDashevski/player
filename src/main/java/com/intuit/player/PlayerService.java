package com.intuit.player;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlayerService {
    Player get(String id);
    List<Player> getAll();

}
