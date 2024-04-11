package com.example.Leavemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;


@SpringBootApplication
public class LeavemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeavemanagementApplication.class, args);
	}

}
