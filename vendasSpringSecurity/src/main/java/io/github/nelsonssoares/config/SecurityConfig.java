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
		super.configure(auth);
		
	}
	
	@Override
	protected void configure(){
		super.configure(http);
	}
	
	
}
*/