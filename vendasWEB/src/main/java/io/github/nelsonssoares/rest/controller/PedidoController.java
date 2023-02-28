package io.github.nelsonssoares.rest.controller;

import static org.springframework.http.HttpStatus.*;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.nelsonssoares.domain.entity.ItemPedido;
import io.github.nelsonssoares.domain.entity.Pedido;
import io.github.nelsonssoares.rest.dto.InfoItemDTO;
import io.github.nelsonssoares.rest.dto.InfoPedidoDTO;
import io.github.nelsonssoares.rest.dto.PedidoDTO;
import io.github.nelsonssoares.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	private PedidoService service;
	
	public PedidoController(PedidoService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(CREATED)
	public Integer save(@RequestBody PedidoDTO dto) {
		Pedido pedido = service.salvar(dto);
		return pedido.getId();
	}
	
	@GetMapping("{id}")
	public InfoPedidoDTO getById(@PathVariable Integer id) {
		return service.obterPedidoCompleto(id)
				.map(p -> converter(p))
				.orElseThrow(()-> new ResponseStatusException(NOT_FOUND, "Pedido não encontrado!"));
	}
	
	private InfoPedidoDTO converter(Pedido pedido) {
		return InfoPedidoDTO.builder().codigo(pedido.getId())
		.dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
		.cpf(pedido.getCliente().getCpf())
		.nome(pedido.getCliente().getNome())
		.total(pedido.getTotal())
		.items(converter(pedido.getItems()))
		.build();
	}
	
	private List<InfoItemDTO> converter(List<ItemPedido> itens){
		if(CollectionUtils.isEmpty(itens)) {
			return Collections.emptyList();
		}
		return itens.stream()
				.map(item -> InfoItemDTO
						.builder()
						.descricaoProduto(item.getProduto().getDescricao())
						.precoUnitario(item.getProduto().getPreco())
						.quantidade(item.getQuantidade())
						.build()
						
						)
				.collect(Collectors.toList());
		
	}
	
}
