package com.intuit.player;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //random port
public class ListPlayerTest {

    private static final String LOCALHOST = "http://localhost:";
    private static final String URI = "/api/players/";

    private static final String PLAYER_ID = "aardsda01";
    private static final String GIVEN_NAME = "David Allan";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test get player with empty id
     */
    @Test
    public void getMissingId() {
        String url = LOCALHOST + port + URI;
        assertThat(restTemplate.getForEntity(url, Player.class).getStatusCode()== HttpStatus.NOT_FOUND);

    }
    /**
     * Test notfound ID for requesting player
     */
    @Test
    public void notFoundPlayerID() {
        String url = LOCALHOST + port + URI + "BAD_ID";
        assertThat(restTemplate.getForEntity(url, Player.class).getStatusCode() == HttpStatus.NOT_FOUND);
    }


    /**
     * Test get player by ID success flow
     */
    @Test
    public void getPlayerCorrectID()  {
        String url = LOCALHOST + port + URI + PLAYER_ID;
        ResponseEntity<Player> responseEntity = restTemplate.getForEntity(url, Player.class);
        assertThat(responseEntity).isNotNull();
        Player player = responseEntity.getBody();
        if (player!=null) {
            assertThat(GIVEN_NAME.equals(player.getNameGiven()));
        }
    }

}
