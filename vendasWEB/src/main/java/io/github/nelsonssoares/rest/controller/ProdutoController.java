package io.github.nelsonssoares.rest.controller;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.nelsonssoares.domain.entity.Produto;
import io.github.nelsonssoares.domain.repository.Produtos;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	private Produtos produtosRepo;
	
	public ProdutoController(Produtos produtosRepo) {
		this.produtosRepo = produtosRepo;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto save(@RequestBody Produto produto) {
		return produtosRepo.save(produto);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Produto update(@PathVariable Integer id, @RequestBody Produto produto) {
		return produtosRepo.findById(id)
		.map(p -> {
			produto.setId(p.getId());
			produtosRepo.save(produto);
			return produto;
		})
		.orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		produtosRepo
		.findById(id)
		.map(p -> {
			produtosRepo.deleteById(id);
			return Void.TYPE;
		})
		.orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}
	
	@GetMapping("{id}")
	public Produto getById(@PathVariable Integer id) {
		return produtosRepo.findById(id)
				.orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}
	
	
	
	@GetMapping
	public List<Produto> find(Produto filtro) { //busacando produto com parametros diferentes
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Produto> example = Example.of(filtro, matcher );
		
		return produtosRepo.findAll(example);
	}
	
	
}
