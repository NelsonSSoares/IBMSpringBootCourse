package io.github.nelsonssoares.rest.controller;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.nelsonssoares.domain.entity.Cliente;
import io.github.nelsonssoares.domain.repository.Clientes;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {
	
//	@RequestMapping(value = "/hello/{nome}",
//					method = RequestMethod.GET,
//					consumes = {"application/json", "application/xml"},
//					produces = {"application/json", "application/xml"}
//					)
//	@ResponseBody
//	public String helloClientes(@PathVariable("nome") String nomeCliente) {
//		return String.format("Hello %s", nomeCliente);
//	}
	
	private Clientes clientes;
	
	
	public ClienteController(Clientes clientes) {
		this.clientes = clientes;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Cliente> getClienteById (@PathVariable Integer id) {
		
		Optional<Cliente> cliente = clientes.findById(id);
		
		if(cliente.isPresent()) {		
//			HttpHeaders headers = new HttpHeaders();
//			headers.put("Authorization", "token")		
//			ResponseEntity<Cliente> responseEntity = new ResponseEntity<Cliente>(cliente.get() , headers , HttpStatus.OK, );
			
			return ResponseEntity.ok(cliente.get()); //retorna cliente caso ecista com codigo status 200
		}
		
		return ResponseEntity.notFound().build(); // cliente não encontrado 404
		
				
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity save(@RequestBody Cliente cliente) { //ResquestBody, vem na requisição input | ResponseBody retorna resposta, output 
		Cliente clienteSalvo = clientes.save(cliente);
		
		return ResponseEntity.ok(clienteSalvo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity delete(@PathVariable Integer id) {
		
		Optional<Cliente> cliente = clientes.findById(id);
		
		if(cliente.isPresent()) {
			clientes.delete(cliente.get());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		
		return clientes.findById(id).map(clienteExistente ->{
			cliente.setId(clienteExistente.getId());
			clientes.save(cliente);
			return ResponseEntity.noContent().build();
		}).orElseGet( () -> ResponseEntity.notFound().build() );
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity find(Cliente filtro) { //busacando cliente com parametros diferentes
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING);
		
		Example example = Example.of(filtro, matcher );
		
		List<Cliente> lista = clientes.findAll(example);
		
		return ResponseEntity.ok(lista);
		
	}
	
}
