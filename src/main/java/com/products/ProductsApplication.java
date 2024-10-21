package com.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@EnableCaching
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

}
