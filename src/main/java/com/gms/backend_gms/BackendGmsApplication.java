package com.gms.backend_gms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

public class BackendGmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendGmsApplication.class, args);
	}

}
