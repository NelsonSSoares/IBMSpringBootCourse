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
	private List<InfoItemDTO> items;
	
	
	public InfoPedidoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	


	public InfoPedidoDTO(Integer codigo, String cpf, String nome, BigDecimal total, String dataPedidio,
			List<InfoItemDTO> items) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
		this.total = total;
		this.dataPedido = dataPedidio;
		this.items = items;
	}





	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public String getDataPedidio() {
		return dataPedido;
	}


	public void setDataPedidio(String dataPedidio) {
		this.dataPedido = dataPedidio;
	}


	public List<InfoItemDTO> getItems() {
		return items;
	}


	public void setItems(List<InfoItemDTO> items) {
		this.items = items;
	}




	@Override
	public String toString() {
		return "InfoPedidoDTO [codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome + ", total=" + total
				+ ", dataPedidio=" + dataPedido + ", items=" + items + "]";
	}
	
	
	
	
}
