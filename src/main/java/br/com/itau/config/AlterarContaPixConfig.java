package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.AlterarChavePixAdapter;
import br.com.itau.application.core.usecase.AlterarChavePixUseCase;
import br.com.itau.application.core.usecase.BuscarChavePixIdUseCase;
import br.com.itau.application.core.usecase.BuscarContaAgenciaContaUseCase;

@Configuration
public class AlterarContaPixConfig {

	@Bean
	public  AlterarChavePixUseCase alterarChavePixUseCase(BuscarChavePixIdUseCase buscarChavePixIdUseCase, 
			AlterarChavePixAdapter alterarChavePixAdapter,
			BuscarContaAgenciaContaUseCase buscarContaAgenciaContaUseCase) {
		
		return new AlterarChavePixUseCase(buscarChavePixIdUseCase, alterarChavePixAdapter, buscarContaAgenciaContaUseCase);
	}
}
