package io.github.nelsonssoares.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.nelsonssoares.domain.entity.Cliente;
import io.github.nelsonssoares.domain.entity.ItemPedido;
import io.github.nelsonssoares.domain.entity.Pedido;
import io.github.nelsonssoares.domain.entity.Produto;
import io.github.nelsonssoares.domain.enums.StatusPedido;
import io.github.nelsonssoares.domain.repository.Clientes;
import io.github.nelsonssoares.domain.repository.ItemsPedido;
import io.github.nelsonssoares.domain.repository.Pedidos;
import io.github.nelsonssoares.domain.repository.Produtos;
import io.github.nelsonssoares.exception.PedidoNaoEncontradoException;
import io.github.nelsonssoares.exception.RegraNegocioException;
import io.github.nelsonssoares.rest.dto.ItemPedidoDTO;
import io.github.nelsonssoares.rest.dto.PedidoDTO;
import io.github.nelsonssoares.service.PedidoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
	
	private final Pedidos pedidoRepo;
	private final Clientes clientesRepo;
	private final Produtos produtosRepo;
	private final ItemsPedido itemsPedidoRepo;
	

	
//	public PedidoServiceImpl(Pedidos pedidoRepo, Clientes clientesRepo, Produtos produtosRepo,
//			ItemsPedido itemsPedidoRepo) {
//		super();
//		this.pedidoRepo = pedidoRepo;
//		this.clientesRepo = clientesRepo;
//		this.produtosRepo = produtosRepo;
//		this.itemsPedidoRepo = itemsPedidoRepo;
//	}



	@Transactional // só permite armazenamento no DB caso tudo ocorra com sucesso, do contrario é feito um rollback e a operação é desfeita
	@Override
	public Pedido salvar(PedidoDTO dto) {
		
		Integer idCliente = dto.getCliente();
		Cliente cliente = clientesRepo.findById(idCliente).orElseThrow(() -> new RegraNegocioException("Código de Cliente inválido!"));
		
		Pedido pedido = new Pedido();
		pedido.setTotal(dto.getTotal());
		pedido.setDataPedido(LocalDate.now());
		pedido.setCliente(cliente);
		
		List<ItemPedido> itemPedido = converterItems(pedido, dto.getItems());
		pedidoRepo.save(pedido);
		itemsPedidoRepo.saveAll(itemPedido);
		pedido.setItems(itemPedido);
		pedido.setStatus(StatusPedido.REALIZADO);
		return pedido;
	}
	
	
	
	private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items) {
		if(items.isEmpty()) {
			throw new RegraNegocioException("Não é possivel realizar pedido sem items.");
		}
		
		return items.stream()
				.map(dto -> {
					
					Integer idProduto = dto.getProduto();
					Produto produto = produtosRepo.findById(idProduto).orElseThrow(() -> new RegraNegocioException("Código de produto Inválido:" + idProduto));
					
					ItemPedido itemPedido = new ItemPedido();
					
					itemPedido.setQuantidade(dto.getQuantidade());
					itemPedido.setPedido(pedido);
					itemPedido.setProduto(produto);
					return itemPedido;
				}).collect(Collectors.toList());
	}

	@Override
	public Optional<Pedido> obterPedidoCompleto(Integer id) {
		
		return pedidoRepo.findByIdFetchItens(id);
	}


	@Transactional
	@Override
	public void atualizaStatus(Integer id, StatusPedido statusPedido) {
		pedidoRepo.findById(id)
		.map(pedido -> {
			pedido.setStatus(statusPedido);
			return pedidoRepo.save(pedido); 
		}).orElseThrow(()-> new PedidoNaoEncontradoException());
	}
}
