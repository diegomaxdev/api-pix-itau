package br.com.itau.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ChavePixRepository;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.out.DeleteChavePixOutPutPort;

@Component
public class DeleteChavePixAdapter implements DeleteChavePixOutPutPort{

	@Autowired
	private ChavePixRepository chavePixRepository;
	
	@Autowired
	private ChavePixEntityMapper chavePixEntityMapper;
	
	@Override
	public ChavePix delete(ChavePix chavePix) {
		
		var chavePixEntity = chavePixEntityMapper.toChavePixEntity(chavePix);
		var chaveAlterada = chavePixRepository.save(chavePixEntity);
		return chavePixEntityMapper.toChavePix(chaveAlterada);
	}
}
