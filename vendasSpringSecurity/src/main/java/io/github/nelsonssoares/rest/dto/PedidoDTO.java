package io.github.nelsonssoares.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import io.github.nelsonssoares.validation.NotEmptyList;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	@NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Integer cliente;
	@NotNull(message = "{campo.total-pedidos.obrigatorio}")
    private BigDecimal total;
	@NotEmptyList(message = "{campo.items-pedido.obrigatorio}")
    private List<ItemPedidoDTO> items;
}
