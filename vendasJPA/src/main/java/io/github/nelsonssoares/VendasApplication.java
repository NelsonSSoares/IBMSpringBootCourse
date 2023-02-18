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
			clientes.salvar(cliente);
			

			Cliente cliente2 = new Cliente("Juarez");
			clientes.salvar(cliente2);
			
			
			System.out.println("Listando todos os Clientes");
			List<Cliente>todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			
			System.out.println("Atualizando Clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + "Updated");
				clientes.atualiza(c);
			});
//			
			//clientes.deletar(2);
			System.out.println("Buscando Cliente por Nome");
			clientes.buscarPorNome("Nel").forEach(System.out::println);
			
			
			System.out.println("Deletando Cliente 2");
			clientes.deletar(2);
			todosClientes = clientes.obterTodos();
			System.out.println(todosClientes);
			
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
