package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.ConsultarChavePixAdapter;
import br.com.itau.application.core.usecase.ConsultaChavePixUseCase;

@Configuration
public class ConsultaChavePixConfig {

	@Bean
	public ConsultaChavePixUseCase consultarChavePixUseCase(ConsultarChavePixAdapter consultarChavePixAdapter) {
		return new ConsultaChavePixUseCase(consultarChavePixAdapter);
	}
}
