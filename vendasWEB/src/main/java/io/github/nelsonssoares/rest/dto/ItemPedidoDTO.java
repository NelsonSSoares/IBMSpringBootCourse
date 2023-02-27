package io.github.nelsonssoares.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ItemPedidoDTO {
	
	private Integer produto;
	private Integer quantidade;
	
	public ItemPedidoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemPedidoDTO(Integer produto, Integer quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	public Integer getProduto() {
		return produto;
	}
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}	
	
	
	
	
}

/*
 * LOMBOK ANNOTATIONS
 * 
 * @GETTERS
 * @SETTERS
 * @NOARGSCONSTRUCTOR
 * @ALLARGSCONSTRUCTOR
 * @DATA
 * @TOSTRING
 */
