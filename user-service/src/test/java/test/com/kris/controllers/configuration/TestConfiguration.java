package test.com.kris.controllers.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Configuration
public class TestConfiguration {
	
	@Bean
	public PodamFactory podamFactory(){
		return new PodamFactoryImpl();
	}
	
	
}
