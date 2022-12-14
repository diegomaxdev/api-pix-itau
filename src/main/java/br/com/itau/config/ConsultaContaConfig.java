package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.ConsultarContaAdapter;
import br.com.itau.application.core.usecase.ConsultaContaUseCase;

@Configuration
public class ConsultaContaConfig {

	@Bean
	public ConsultaContaUseCase consultarContaUseCase(ConsultarContaAdapter consultarContaAdapter) {
		return new ConsultaContaUseCase(consultarContaAdapter);
	}
}
