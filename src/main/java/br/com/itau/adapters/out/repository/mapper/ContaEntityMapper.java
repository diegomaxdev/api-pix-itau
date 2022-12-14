package br.com.itau.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import br.com.itau.adapters.out.repository.entity.ContaEntity;
import br.com.itau.application.core.domain.Conta;

@Mapper(componentModel = "spring")
public interface ContaEntityMapper {

	ContaEntity toContaEntity(Conta conta);
	
	Conta toConta(ContaEntity contaEntity);
}
