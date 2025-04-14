package com.taller;

import com.taller.infraestructure.driven_adapters.dynamodb.employee.config.DynamoDbTableConfig;
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
		return args -> config.createTable("employee")
				.doOnSuccess(v -> System.out.println("Tabla creada exitosamente"))
				.doOnError(Throwable::printStackTrace)
				.subscribe();
	}

}
