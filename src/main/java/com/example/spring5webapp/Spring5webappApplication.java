package com.example.spring5webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Spring5webappApplication.class, args);
		System.out.println("Hello From Spring");

	}

}


