package io.github.nelsonssoares.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	@NotNull(message = "Informe codigo do cliente!")
    private Integer cliente;
	@NotNull(message = "o total do pedido é obrigatorio")
    private BigDecimal total;
    private List<ItemPedidoDTO> items;
}
