package com.tliner.worstFilm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tliner.worstFilm.service.ReadFileImpl;
@SpringBootApplication
public class WorstFilmApplication implements CommandLineRunner {

	@Autowired
	private ReadFileImpl readFileImpl;

	public static void main(String[] args) {
		SpringApplication.run(WorstFilmApplication.class, args);
		
	}

	@Override
	public void run(String... args) {

		readFileImpl.databaseLoading();

	}

}
