package io.github.nelsonssoares.service;

import io.github.nelsonssoares.domain.entity.Pedido;
import io.github.nelsonssoares.rest.dto.PedidoDTO;

public interface PedidoService {
	Pedido salvar(PedidoDTO dto);
}
