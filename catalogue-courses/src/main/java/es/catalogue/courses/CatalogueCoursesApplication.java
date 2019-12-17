package es.catalogue.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
//This annotation contains @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.
public class CatalogueCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueCoursesApplication.class, args);
	}

}
