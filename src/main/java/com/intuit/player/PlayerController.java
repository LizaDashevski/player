package com.intuit.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    /**
     * GET /api/players - returns the list of all players
     */
    @GetMapping()
    List<Player> getAllPlayers() { return playerService.getAll(); }

    /**
     * GET /api/players/{playerID} get single player by id
     * @param id playerID
     * @return   player as JSON
     */
    @GetMapping("/{id}")
    Player getPlayer(@PathVariable String id) { return playerService.get(id); }
}
