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
