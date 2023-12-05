package com.intuit.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    @Transactional
    public Player get(String id) {
        return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

}
