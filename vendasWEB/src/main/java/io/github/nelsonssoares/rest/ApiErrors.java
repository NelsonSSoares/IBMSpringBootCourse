package io.github.nelsonssoares.rest;

import java.util.Arrays;
import java.util.List;

/*
 * CLASSE PARA MANIPULAR EXCESSÕES DE FORMA PERSONALIZADA COM SEUS DEVIDOS STATUS
 */


public class ApiErrors {
	
	private List<String> errors;
	
	public ApiErrors(String errorMessage) {
		this.errors = Arrays.asList(errorMessage);
	}

	public List<String> getErrors() {
		return errors;
	}


	
}
