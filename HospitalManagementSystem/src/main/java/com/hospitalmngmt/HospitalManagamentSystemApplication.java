package com.hospitalmngmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalManagamentSystemApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(HospitalManagamentSystemApplication.class, args);
		System.out.println("Hospital Mangement starting");
	}

}
