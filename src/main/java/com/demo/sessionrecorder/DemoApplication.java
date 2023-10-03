package com.demo.sessionrecorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.demo.sessionrecorder.repository.OperatorRepository;
import com.demo.sessionrecorder.model.Operator;


@SpringBootApplication
public class DemoApplication {

	@Autowired
	OperatorRepository operatorRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(OperatorRepository operatorRepository) {
		return (args) -> {

			if (!operatorRepository.existsByName("OP: Ostkreuz")){
				Operator operatorOstkreuz = new Operator();
				operatorOstkreuz.setName("OP Ostkreuz");
				operatorRepository.save(operatorOstkreuz);
			}

			if (!operatorRepository.existsByName("OP: Südkreuz")){
				Operator operatorSuedkreuz = new Operator();
				operatorSuedkreuz.setName("OP Südkreuz");
				operatorRepository.save(operatorSuedkreuz);
			}

			if (!operatorRepository.existsByName("OP: Westkreuz")){
				Operator operatorWestkreuz = new Operator();
				operatorWestkreuz.setName("OP Westkreuz");
				operatorRepository.save(operatorWestkreuz);
			}
		};
	}
}
