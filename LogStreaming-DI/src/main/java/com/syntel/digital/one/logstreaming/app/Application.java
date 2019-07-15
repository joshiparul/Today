package com.syntel.digital.one.logstreaming.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@SpringBootApplication  
@ComponentScan(basePackages = {"com.syntel.digital.one.logstreaming.*"})
public class Application {
	public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  

}
}
