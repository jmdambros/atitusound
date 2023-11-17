package br.edu.atitus.atitusound.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigSwagger {
	@Bean
	public OpenAPI getOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Atitusound")
						.description("Documentação backend Atitusound")
						.version("Version 1")
						.contact(new Contact()
								.name("João Marcelo Dambrós")
								.email("jmcdambros@gmail.com")
						));
	}
}
