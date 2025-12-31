package com.business.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class MedicalCentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalCentreApplication.class, args);
	}

}
