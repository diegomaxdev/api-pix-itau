package br.com.itau.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.itau.adapters.in.controller.request.ConsultaContaRequest;
import br.com.itau.adapters.in.controller.request.InserirContaRequest;
import br.com.itau.adapters.in.controller.response.ContaResponse;
import br.com.itau.application.core.domain.Conta;

@Mapper(componentModel = "spring")
public interface ContaControllerMapper {

	@Mapping(target = "dataInclusao", ignore = true)
	Conta toConta(InserirContaRequest inserirContaRequest);
	
	@Mapping(target = "dataInclusao", ignore = true)
	@Mapping(target = "tipoConta", ignore = true)
	@Mapping(target = "tipoPessoa", ignore = true)
	Conta toConta(ConsultaContaRequest consultaContaRequest);
	
	ContaResponse toContaResponse(Conta conta);
}
