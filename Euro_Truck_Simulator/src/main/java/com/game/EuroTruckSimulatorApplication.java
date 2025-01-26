package com.game;

import com.game.launcher.Launcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EuroTruckSimulatorApplication implements ApplicationRunner {
	@Autowired
	private Launcher launcher;
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(EuroTruckSimulatorApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		launcher.Start();
	}
}
