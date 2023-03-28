package io.github.nelsonssoares.service;

import io.github.nelsonssoares.domain.entity.Pedido;
import io.github.nelsonssoares.domain.enums.StatusPedido;
import io.github.nelsonssoares.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
