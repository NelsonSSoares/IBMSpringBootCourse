//package io.github.nelsonssoares.rest;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import io.github.nelsonssoares.exception.PedidoNaoEncontradoException;
//import io.github.nelsonssoares.exception.RegraNegocioException;
//
//
//
//@RestControllerAdvice 
//public class ApplicationControllerAdvice2 {
//	
//	@ExceptionHandler(RegraNegocioException.class) // indica metodo que manipula as excessoes
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ApiErrors handleRegrasNegocioException(RegraNegocioException ex) {
//		String message = ex.getMessage();
//				
//		return new ApiErrors(message);
//	}
//	
//	@ExceptionHandler(PedidoNaoEncontradoException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public ApiErrors handlePedidoNotFoundException(PedidoNaoEncontradoException ex) {
//			return new ApiErrors(ex.getMessage());
//	}
//}
