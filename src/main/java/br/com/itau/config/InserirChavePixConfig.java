package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.InserirChavePixAdapter;
import br.com.itau.application.core.usecase.BuscarChavePixAgenciaContaUseCase;
import br.com.itau.application.core.usecase.BuscarChavePixUseCase;
import br.com.itau.application.core.usecase.BuscarContaAgenciaContaUseCase;
import br.com.itau.application.core.usecase.InserirChavePixUseCase;

@Configuration
public class InserirChavePixConfig {

	@Bean
	public InserirChavePixUseCase inserirChavePixUseCase(BuscarChavePixUseCase buscarChavePixUseCase,
			InserirChavePixAdapter inserirChavePixAdapter,
			BuscarChavePixAgenciaContaUseCase buscarChavePixAgenciaContaUseCase,
			BuscarContaAgenciaContaUseCase buscarContaAgenciaContaUseCase) {

		return new InserirChavePixUseCase(buscarChavePixUseCase, inserirChavePixAdapter,
				buscarChavePixAgenciaContaUseCase, buscarContaAgenciaContaUseCase);
	}
}
