package com.example.customer;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.mappers.CustomerMapper;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {




	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService){
		return args -> {
			customerService.save(new CustomerRequestDTO("","Fab","fabrice@Nnokam.com"));
			customerService.save(new CustomerRequestDTO("","Astek","astek@canada.com"));
		};
	}
	
}
