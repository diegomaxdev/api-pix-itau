package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.BuscarChavePixAgenciaContaAdapter;
import br.com.itau.application.core.usecase.BuscarChavePixAgenciaContaUseCase;

@Configuration
public class BuscarChavePixAgenciaContaConfig {

	@Bean
	public BuscarChavePixAgenciaContaUseCase buscarChavePixAgenciaContaUseCase(BuscarChavePixAgenciaContaAdapter buscarChavePixAgenciaContaAdapter) {
		return new BuscarChavePixAgenciaContaUseCase(buscarChavePixAgenciaContaAdapter);
	}
}
