package com.intuit.player;

import com.intuit.player.data.DataFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlayerApplication implements CommandLineRunner {
	@Autowired
	private DataFiller dataFiller;

	public static void main(String[] args) {
		SpringApplication.run(PlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataFiller.initializeDatabase();
	}

}
