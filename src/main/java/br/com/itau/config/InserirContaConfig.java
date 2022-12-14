package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.InserirContaAdapter;
import br.com.itau.application.core.usecase.InserirContaUseCase;

@Configuration
public class InserirContaConfig {

	@Bean
	public InserirContaUseCase inserirContaUseCase(InserirContaAdapter inserirContaPixAdapter) {

		return new InserirContaUseCase(inserirContaPixAdapter);
	}
}
