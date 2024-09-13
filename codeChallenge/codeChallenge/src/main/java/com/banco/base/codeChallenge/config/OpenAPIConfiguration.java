package com.banco.base.codeChallenge.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {

	@Value("${openapi.local-url}")
	private String localUrl;

	@Bean
	OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(localUrl);
		devServer.setDescription("Server URL in Local environment");

		Contact contact = new Contact();
		contact.setEmail("mbc_1710@hotmail.com");
		contact.setName("Maciel Benitez");

		Info info = new Info().title("Code challenge").version("1.0").contact(contact)
				.description("This api is for code challenge to banco base");

		return new OpenAPI().info(info).servers(List.of(devServer));
	}
}
