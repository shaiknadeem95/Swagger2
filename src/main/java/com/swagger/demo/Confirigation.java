package com.swagger.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.RequestHandledEvent;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@ComponentScan({"com.swagger.demo.pojo","com.swagger.demo"})
public class Confirigation {
	@Bean
	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
//				.paths((Predicate<String>) PathSelectors.any()).build();
		System.out.println("Docket");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.swagger"))
				.build();
	}
}
