package com.irede;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi Doc", version = "1", description = "API desenvolvida para testes do iRede"))
public class CatalogoIredeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoIredeApplication.class, args);
	}

}
