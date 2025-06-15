package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * The type Emp backend application.
 */
@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class EmpBackendApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmpBackendApplication.class, args);
	}

}
