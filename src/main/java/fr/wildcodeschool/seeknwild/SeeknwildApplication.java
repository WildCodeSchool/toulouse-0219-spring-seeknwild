package fr.wildcodeschool.seeknwild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SeeknwildApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeeknwildApplication.class, args);
	}

}
