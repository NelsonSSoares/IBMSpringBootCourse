package io.github.nelsonssoares.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//VERSÃO DESCONTINUADA DO WebSecurityConfigurerAdapter, ARRUMAR CONFIGURAÇÃO DA NOVA VERSÃO
@EnableWebSecurity
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {
	
	// METODO DE AUTENTICAÇÃO
	//@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth)
	}
	//METODO DE AUTORIZAÇÃO
	//@Override
	protected void configure(HttpSecurity http)throws Exception{
		//super.configure(http)
	}
	
	
}
