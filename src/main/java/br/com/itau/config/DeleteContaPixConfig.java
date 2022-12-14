package br.com.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.itau.adapters.out.DeleteChavePixAdapter;
import br.com.itau.application.core.usecase.BuscarChavePixIdUseCase;
import br.com.itau.application.core.usecase.DeleteChavePixUseCase;

@Configuration
public class DeleteContaPixConfig {

	@Bean
	public DeleteChavePixUseCase deleteChavePixUseCase(BuscarChavePixIdUseCase buscarChavePixIdUseCase, DeleteChavePixAdapter deleteChavePixAdapter) {
		
		return new DeleteChavePixUseCase(buscarChavePixIdUseCase, deleteChavePixAdapter);
	}
}
