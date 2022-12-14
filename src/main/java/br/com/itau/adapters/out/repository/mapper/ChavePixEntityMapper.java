package br.com.itau.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import br.com.itau.adapters.out.repository.entity.ChavePixEntity;
import br.com.itau.application.core.domain.ChavePix;

@Mapper(componentModel = "spring")
public interface ChavePixEntityMapper {

	ChavePixEntity toChavePixEntity(ChavePix chavePix);
	
	ChavePix toChavePix(ChavePixEntity chavePixEntity);
}
