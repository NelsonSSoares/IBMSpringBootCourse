package io.github.nelsonssoares.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nelsonssoares.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer> {
	
	
}
