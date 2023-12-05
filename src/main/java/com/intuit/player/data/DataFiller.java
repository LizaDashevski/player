package com.intuit.player.data;

import com.intuit.player.Player;
import com.intuit.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

@Configuration
public class DataFiller {
    @Autowired
    private PlayerRepository playerRepository;

    private static final String fileName = "/resources/player.csv";

    // this will run once on microservice start up. This will parse player.csv and save to db
    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            File file = new File(fileName);
            try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {
                //skip headlines
                if(sc.hasNextLine()) sc.nextLine();
                //for each row, parse and save to db
                while (sc.hasNextLine()) {
                    String[] row = getRow(sc);
                    Player player = playerFromCSV(row);
                    playerRepository.save(player);
                }
            }
            catch (IOException e) {e.printStackTrace(); }
        };
    }

    private static String[] getRow(Scanner sc) {
        String[] row = sc.nextLine().split(",");
        //pad with null in case of partial row
        return Arrays.copyOf(row, 24);
    }

    private static Integer columnToIntVal(String column) {
        return (column == null || column.isEmpty()) ? 0 : Integer.parseInt(column);
    }

    Player playerFromCSV(String[] row ) {
        Player p = new Player();

        p.setPlayerID(row[0]);
        p.setBirthYear(columnToIntVal(row[1]));
        p.setBirthMonth(columnToIntVal(row[2]));
        p.setBirthDay(columnToIntVal(row[3]));
        p.setBirthCountry(row[4]);
        p.setBirthState(row[5]);
        p.setBirthCity(row[6]);
        p.setDeathYear(columnToIntVal(row[7]));
        p.setDeathMonth(columnToIntVal(row[8]));
        p.setDeathDay(columnToIntVal(row[9]));
        p.setDeathCountry(row[10]);
        p.setDeathState(row[11]);
        p.setDeathCity(row[12]);
        p.setNameFirst(row[13]);
        p.setNameLast(row[14]);
        p.setNameGiven(row[15]);
        p.setWeight(columnToIntVal(row[16]));
        p.setHeight(columnToIntVal(row[17]));
        p.setBats(row[18]);
        p.setBbthrows(row[19]);
        p.setDebut(row[20]);
        p.setFinalGame(row[21]);
        p.setRetroID(row[22]);
        p.setBbrefID(row[23]);

        return p;
    }

}
