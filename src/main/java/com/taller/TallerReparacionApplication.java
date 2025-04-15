package com.taller;

import com.taller.infraestructure.driven_adapters.dynamodb.config.DynamoDbTableConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TallerReparacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerReparacionApplication.class, args);
	}

	@Bean
	CommandLineRunner createTables(DynamoDbTableConfig config) {
		return args -> config.createRepairServiceTable()
				.doOnSuccess(v -> System.out.println("RepairServiceTable creada exitosamente"))
				.doOnError(Throwable::printStackTrace)
				.subscribe();
	}

}
