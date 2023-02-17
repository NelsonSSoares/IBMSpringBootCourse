import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.nelsonssoares.Animal;

@Configuration
public class AnimalConfiguration {
	@Bean(name = "cachorro")
	public Animal cachorro() {
		return new Animal() {
			@Override
			public void fazerBarulho() {
				System.out.println("AUAU");
				
			}
		};
	}
	
	
	@Bean(name = "gato")
	public Animal gato() {
		return new Animal() {
			@Override
			public void fazerBarulho() {
				
				System.out.println("MIMNHAUM");
			}
		};
	}
}
