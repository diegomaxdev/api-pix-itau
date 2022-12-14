package br.com.itau.adapters.out.integration.mapper;

import org.mapstruct.Mapper;

import br.com.itau.adapters.out.integration.response.ContaResponseIntegration;
import br.com.itau.application.core.domain.Conta;

@Mapper(componentModel = "spring")
public interface ContaComplementoMapper {

	Conta toConta(ContaResponseIntegration contaResponse);	
}
