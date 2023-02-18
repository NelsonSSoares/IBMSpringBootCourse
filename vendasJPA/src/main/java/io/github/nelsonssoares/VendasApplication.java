package io.github.nelsonssoares;

import java.util.List;

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
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			
			System.out.println("Salvando cliente");
			Cliente cliente = new Cliente();
			
			cliente.setNome("Nelson");
			clientes.save(cliente);		
			Cliente cliente2 = new Cliente("Juarez");
			clientes.save(cliente2);
			
			boolean exists = clientes.existsByNome("Nelson");
			
			System.out.println("Cliente Nelson já existe?"+exists);
			
			
			
			
			
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
