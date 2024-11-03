package es.iesjandula.reaktor_Issues_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

public class ReaktorIssuesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaktorIssuesServerApplication.class, args);
	}

}
