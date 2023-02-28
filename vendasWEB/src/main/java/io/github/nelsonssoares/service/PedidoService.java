package io.github.nelsonssoares.service;

import java.util.Optional;

import io.github.nelsonssoares.domain.entity.Pedido;
import io.github.nelsonssoares.domain.enums.StatusPedido;
import io.github.nelsonssoares.rest.dto.PedidoDTO;

public interface PedidoService {
	Pedido salvar(PedidoDTO dto);
	
	Optional<Pedido> obterPedidoCompleto(Integer id);
	
	void atualizaStatus(Integer id, StatusPedido statusPedido);
}
