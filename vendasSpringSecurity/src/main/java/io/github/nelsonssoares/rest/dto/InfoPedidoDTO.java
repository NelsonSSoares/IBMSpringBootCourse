package io.github.nelsonssoares.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
public class InfoPedidoDTO {
	
	private Integer codigo;
	private String cpf;
	private String nome;
	private BigDecimal total;
	private String dataPedido;
	private String status;
	private List<InfoItemDTO> items;
	
	
	public InfoPedidoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public InfoPedidoDTO(Integer codigo, String cpf, String nome, BigDecimal total, String dataPedido, String status,
			List<InfoItemDTO> items) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
		this.total = total;
		this.dataPedido = dataPedido;
		this.status = status;
		this.items = items;
	}


	
	
	
	
}
