package com.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value=MyMessage.class)
public class SpringBoot2Application {
	
	@Autowired
	private MyMessage myMessage;
	
	@RequestMapping("/")
	public String welcome(){
		
		return "Welcome, your lucky number is " + myMessage.getMessageValue();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2Application.class, args);
	}
}
