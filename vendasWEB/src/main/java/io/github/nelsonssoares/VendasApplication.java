package io.github.nelsonssoares;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.nelsonssoares.domain.entity.Cliente;
import io.github.nelsonssoares.domain.repository.Clientes;

@SpringBootApplication
public class VendasApplication {
	
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes clientes) {
		return args -> {
			Cliente c = new Cliente(null, "Nelson");
			clientes.save(c); 
		};
	}

	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
