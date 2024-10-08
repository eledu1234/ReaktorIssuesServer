package es.iesjandula.ReaktorIssuesServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Configuration
@ComponentScan(basePackages = {"es.iesjandula.ReaktorIssuesServer"})
public class ReaktorIssuesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaktorIssuesServerApplication.class, args);
	}

}
