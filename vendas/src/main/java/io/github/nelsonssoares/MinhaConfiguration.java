package io.github.nelsonssoares;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("development")
@Development
public class MinhaConfiguration {
	
//	@Bean(name = "applicationName")
//	public String appicationName() {
//		return "Sistema de Vendas";
//	}
	
	@Bean(name = "outraConfiguracao")
	public String outraConfiguracao() {
		return "Outra Configuração";
	}
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			System.out.println("RODANDO CONFIG DEVELOPMENT");
		};
	}
	
	
	
	
}
