package io.github.nelsonssoares.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        return http
	            .authorizeHttpRequests(auth ->{
	            	
	            	auth.requestMatchers("api/clientes/**").permitAll().anyRequest().authenticated();	            	
	            }).build();
	            
	       
	    }

}



/*
package io.github.nelsonssoares.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEnconder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
		.withUser("Fulano")
		.password(passwordEncoder.encode("123"))
		.roles("USER") //PODE COLOCAR QUANTAS ROLES QUISER, SEPARADOS POR VIRGULA
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable
		.authorizeRequests()		//.hasAuthority("MANTER USUARIO")
		.antMatchers("/api/clientes/**")
		.authenticated().hasRole("USER")
		.antMatchers("/api/produtos/**")
		.hasRole("ADMIN")
		.antMatchers("/api/pedidos/**")
		.hasRole("USER")
		.and()
		//.formLogin(); // JA VEM FORMULARIO PRONTO DO SPRING, SENDO POSSIVEL COLOCAR PERSONALIZADA ATRAVES DO ENDPOINT "/login.html"
		.httpBasic(); //REQUISIÇÃO VIA HEADER DA REQUISIÇÃO
	}
	
	
}
*/