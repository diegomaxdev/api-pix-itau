package br.com.itau.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ChavePixRepository;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.out.AlterarChavePixOutPutPort;

@Component
public class AlterarChavePixAdapter implements AlterarChavePixOutPutPort{

	@Autowired
	private ChavePixRepository chavePixRepository;
	
	@Autowired
	private ChavePixEntityMapper chavePixEntityMapper;
	
	@Override
	public ChavePix alterar(ChavePix chavePix) {
		
		var chavePixEntity = chavePixEntityMapper.toChavePixEntity(chavePix);
		return chavePixEntityMapper.toChavePix(chavePixRepository.save(chavePixEntity));
	}
}
