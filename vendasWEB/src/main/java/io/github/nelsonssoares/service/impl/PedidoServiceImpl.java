package io.github.nelsonssoares.service.impl;

import org.springframework.stereotype.Service;

import io.github.nelsonssoares.domain.repository.Pedidos;
import io.github.nelsonssoares.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	private Pedidos repository;
	
	public PedidoServiceImpl(Pedidos repository) {
		this.repository = repository;
	}
}
