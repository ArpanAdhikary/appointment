package com.cg.ams;


 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:application_prod.properties")
public class AppointmentmanagementsystemApplication{

	
	
	public static void main(String[] args){
		
		//String path=AppointmentmanagementsystemApplication.class.getResource("").getPath()+"//log.properties";
		//System.setProperty("spring.config.location", path);  
		SpringApplication.run(AppointmentmanagementsystemApplication.class, args);
	}

	
}
