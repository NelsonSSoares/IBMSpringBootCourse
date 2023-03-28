package io.github.nelsonssoares.domain.repository;

import io.github.nelsonssoares.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
