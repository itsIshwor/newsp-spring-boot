package com.ishwor.newp.spring.boot;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableJpaAuditing
public class NewspSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewspSpringBootApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/rest/**"))
				.apis(RequestHandlerSelectors.basePackage("com.ishwor.newp.spring.boot.controller.rest")).build()
				.apiInfo(apiDetails());
	}  

	private ApiInfo apiDetails() {
		return new ApiInfo("newsP", "A simple news demo", "1.0", "For personal use",
				new springfox.documentation.service.Contact("Ishwor Upreti", "http://ishworupreti.com.np",
						"something.com"),
				"", "", Collections.emptyList());
	}

}
