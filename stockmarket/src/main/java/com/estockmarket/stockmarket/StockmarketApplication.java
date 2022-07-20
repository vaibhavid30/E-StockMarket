package com.estockmarket.stockmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class StockmarketApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockmarketApplication.class, args);
	}
}