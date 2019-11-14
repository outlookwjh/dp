package com.designpatterns.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DpApplication {

	public static void main(String[] args) {
		System.out.println("我被执行了");
		SpringApplication.run(DpApplication.class, args);
	}

}
