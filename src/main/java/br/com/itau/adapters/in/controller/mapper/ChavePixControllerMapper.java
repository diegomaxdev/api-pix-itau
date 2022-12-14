package br.com.itau.adapters.in.controller.mapper;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.itau.adapters.in.controller.request.AlterarChavePixRequest;
import br.com.itau.adapters.in.controller.request.ConsultaChavePixRequest;
import br.com.itau.adapters.in.controller.request.InserirChavePixRequest;
import br.com.itau.adapters.in.controller.response.ChavePixConsultaResponse;
import br.com.itau.adapters.in.controller.response.ChavePixDeleteResponse;
import br.com.itau.adapters.in.controller.response.ChavePixResponse;
import br.com.itau.application.core.domain.ChavePix;

@Mapper(componentModel = "spring", imports=StringUtils.class)
public interface ChavePixControllerMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "dataInclusao", ignore = true)
	@Mapping(target = "dataAlteracao", ignore = true)
	@Mapping(target = "dataInativacao", ignore = true)
	ChavePix toChavePix(InserirChavePixRequest chavePixRequest);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "tipoChave", ignore = true)
	@Mapping(target = "valorChave", ignore = true)
	@Mapping(target = "dataInclusao", ignore = true)
	@Mapping(target = "dataAlteracao", ignore = true)
	@Mapping(target = "dataInativacao", ignore = true)
	ChavePix toChavePix(AlterarChavePixRequest chavePixRequest);
	
	@Mapping(target = "sobrenomeCorrentista", expression = "java(chavePix.getSobrenomeCorrentista() != null ? chavePix.getSobrenomeCorrentista() : StringUtils.EMPTY)")
	@Mapping(target = "dataAlteracao", expression = "java(chavePix.getDataAlteracao() != null ? chavePix.getDataAlteracao().toString() : StringUtils.EMPTY)")
	ChavePixResponse toChavePixResponse(ChavePix chavePix);
	
	@Mapping(target = "sobrenomeCorrentista", ignore = true)
	@Mapping(target = "tipoConta", ignore = true)
	@Mapping(target = "valorChave", ignore = true)
	@Mapping(target = "dataInativacao", ignore = true)
	ChavePix toChavePixConsulta(ConsultaChavePixRequest consultaChavePixRequest);
	
		
	@Mapping(target = "sobrenomeCorrentista", expression = "java(chavePix.getSobrenomeCorrentista() != null ? chavePix.getSobrenomeCorrentista() : StringUtils.EMPTY)")
	@Mapping(target = "dataInativacao", expression = "java(chavePix.getDataInativacao() != null ? chavePix.getDataInativacao().toString() : StringUtils.EMPTY)")
	ChavePixDeleteResponse toChavePixDeleteResponse(ChavePix chavePix);
	
	@Mapping(target = "sobrenomeCorrentista", expression = "java(chavePix.getSobrenomeCorrentista() != null ? chavePix.getSobrenomeCorrentista() : StringUtils.EMPTY)")
	@Mapping(target = "dataInativacao", expression = "java(chavePix.getDataInativacao() != null ? chavePix.getDataInativacao().toString() : StringUtils.EMPTY)")
	ChavePixConsultaResponse toChavePixConsultaResponse(ChavePix chavePix);

}
