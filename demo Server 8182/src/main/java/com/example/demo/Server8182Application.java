package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Server8182Application {
	
	/*@RequestMapping("/")
    public String greeting() {
    	//8182端口
        return "HELLO WORLD!";
    }*/

	public static void main(String[] args) {
		SpringApplication.run(Server8182Application.class, args);
	}
}
