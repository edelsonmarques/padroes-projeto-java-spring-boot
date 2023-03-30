package com.marques.edelson;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * Projeto Spring Boot gerado via Spring Initializr -> https://start.spring.io/
 *
 * Spring Data JPA
 * Spring Web
 * H2 Database
 * OpenFeign
 * OpenApi (Swagger)
 *
 */

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info =  @Info(title = "Cliente API", version = "1.0", description = "Client Information"))
public class PadroesProjetoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoSpringBootApplication.class, args);
	}

}
