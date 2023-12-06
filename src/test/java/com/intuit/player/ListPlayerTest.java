package com.intuit.player;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //random port
public class listPlayerTest {

    private static final String LOCALHOST = "http://localhost:";
    private static final String URI = "/api/players/";

    private static final String PLAYER_ID = "aardsda01";
    private static final String FIRST_NAME = "David";
    private static final String LAST_NAME = "Aardsma";
    private static final String GIVEN_NAME = "David Allan";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test get player with empty id
     */
    @Test
    public void getWithNoId() {
        String url = LOCALHOST + port + URI;
        assertThat(restTemplate.getForEntity(url, Player.class).getStatusCode()== HttpStatus.NOT_FOUND);

    }
    /**
     * Test notfound ID for requesting player
     */
    @Test
    public void badPlayerID() {
        String url = LOCALHOST + port + URI + "BAD_ID";
        assertThat(restTemplate.getForEntity(url, Player.class).getStatusCode() == HttpStatus.NOT_FOUND);
    }

}
