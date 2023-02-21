package io.github.nelsonssoares;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.nelsonssoares.domain.entity.Cliente;
import io.github.nelsonssoares.domain.entity.Pedido;
import io.github.nelsonssoares.domain.repository.Clientes;
import io.github.nelsonssoares.domain.repository.Pedidos;

@SpringBootApplication
public class VendasApplication {
	
	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes,  @Autowired Pedidos pedidos) {
		return args -> {
			
			System.out.println("Salvando cliente");
			Cliente cliente = new Cliente();
			
			cliente.setNome("Nelson");
			clientes.save(cliente);	
			
			Pedido p = new Pedido();
			p.setCliente(cliente);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			pedidos.save(p);
//			
//			Cliente nelson = clientes.findClienteFetchPedidos(cliente.getId());
//			
//			System.out.println(nelson);
//			System.out.println(nelson.getPedidos());
			
			pedidos.findByCliente(cliente).forEach(System.out::println);
			
			
			
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
