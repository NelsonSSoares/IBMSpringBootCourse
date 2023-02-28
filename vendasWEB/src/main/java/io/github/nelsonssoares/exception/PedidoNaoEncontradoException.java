package io.github.nelsonssoares.exception;

public class PedidoNaoEncontradoException extends RuntimeException{
	public PedidoNaoEncontradoException() {
		super("Pedido não encontrado");
	}
}
