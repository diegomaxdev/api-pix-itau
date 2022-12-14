package br.com.itau.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ChavePixRepository;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.ports.out.InserirChavePixOutputPort;

@Component
public class InserirChavePixAdapter implements InserirChavePixOutputPort {

	@Autowired
	private ChavePixRepository chavePixRepository;
	
	@Autowired
	private ChavePixEntityMapper chavePixEntityMapper;
	
	@Override
	public ChavePix inserir(ChavePix chavePix) {
		
		var chaventity = chavePixEntityMapper.toChavePixEntity(chavePix);
		var chaveSalva = chavePixRepository.save(chaventity);
		return chavePixEntityMapper.toChavePix(chaveSalva);
	}
}
