package fr.wildcodeschool.seeknwild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties
public class SeeknwildApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SeeknwildApplication.class, args);
	}

}
