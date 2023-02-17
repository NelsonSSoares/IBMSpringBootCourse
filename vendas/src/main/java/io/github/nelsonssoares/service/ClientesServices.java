package io.github.nelsonssoares.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nelsonssoares.model.Cliente;
import io.github.nelsonssoares.repository.ClientesRepository;

@Service
public class ClientesServices {
	
	private ClientesRepository repository; 
	
	/*construtor*/
	@Autowired
	public ClientesServices(ClientesRepository repository) {
		this.repository = repository;
	}
	
	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);	
		this.repository.persistir(cliente);
	}	
	
	public void validarCliente(Cliente cliente) {
		
	}
}
