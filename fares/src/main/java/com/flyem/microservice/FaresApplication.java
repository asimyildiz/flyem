package com.flyem.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * FlyEm Service Application, fares microservice
 * 
 * @author ASIM YILDIZ
 * @version fares-0.0.1-SNAPSHOT
 * @since fares-0.0.1-SNAPSHOT
 */
@SpringBootApplication
public class FaresApplication {

	/**
	 * Main method to run the service application
	 * @param args Application arguments
	 * @since fares-0.0.1-SNAPSHOT
	 */
	public static void main(String[] args) {
		SpringApplication.run(FaresApplication.class, args);
	}

}
