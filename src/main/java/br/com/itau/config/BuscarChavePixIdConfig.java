package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.BuscarChavePixIdAdapter;
import br.com.itau.application.core.usecase.BuscarChavePixIdUseCase;

@Configuration
public class BuscarChavePixIdConfig {

	@Bean
	public BuscarChavePixIdUseCase buscarChavePixIdUseCase(BuscarChavePixIdAdapter buscarChavePixIdAdapter) {
		return new BuscarChavePixIdUseCase(buscarChavePixIdAdapter);
	}
}
