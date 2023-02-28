package io.github.nelsonssoares.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nelsonssoares.domain.entity.Cliente;
import io.github.nelsonssoares.domain.entity.Pedido;

public interface Pedidos extends JpaRepository< Pedido, Integer> {
	List<Pedido> findByCliente(Cliente cliente);
	
	Optional<Pedido> findByIdFetchItens(Integer id);
}
