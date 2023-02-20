package io.github.nelsonssoares.domain.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nelsonssoares.domain.entity.Cliente;
import io.github.nelsonssoares.domain.entity.Pedido;

public interface Pedidos extends JpaRepository< Pedido, Integer> {
	Set<Pedido> findByCliente(Cliente cliente);
}
