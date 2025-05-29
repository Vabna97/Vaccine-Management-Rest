package com.myproject.vaccinemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Vaccine Management API",
		version = "v1.0",
		description = "This API will be used to manage the vaccine stock and details in a clinic"),
		servers = @Server(
				url = "http://localhost:8085/vacmgmt",
				description =" This App is deployed in the following url location")
		)
public class VaccinemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinemanagementApplication.class, args);
	}

}
