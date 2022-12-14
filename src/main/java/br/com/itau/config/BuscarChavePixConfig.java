package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.BuscarChavePixAdapter;
import br.com.itau.application.core.usecase.BuscarChavePixUseCase;

@Configuration
public class BuscarChavePixConfig {

	@Bean
	public BuscarChavePixUseCase buscarChavePixUseCase(BuscarChavePixAdapter buscarChavePixAdapter) {
		return new BuscarChavePixUseCase(buscarChavePixAdapter);
	}
}
