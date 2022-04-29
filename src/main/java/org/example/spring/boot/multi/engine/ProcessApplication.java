package org.example.spring.boot.multi.engine;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
@Slf4j
public class ProcessApplication {

	public static void main(String... args) {
		SpringApplication.run(ProcessApplication.class, args);
	}
}