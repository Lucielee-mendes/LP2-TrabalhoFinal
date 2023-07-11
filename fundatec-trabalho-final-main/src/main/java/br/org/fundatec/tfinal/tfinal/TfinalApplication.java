package br.org.fundatec.tfinal.tfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TfinalApplication.class, args);
	}

}
