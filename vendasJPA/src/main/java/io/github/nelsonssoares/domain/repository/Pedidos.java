package io.github.nelsonssoares.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nelsonssoares.domain.entity.Pedido;

public interface Pedidos extends JpaRepository< Pedido, Integer> {

}
