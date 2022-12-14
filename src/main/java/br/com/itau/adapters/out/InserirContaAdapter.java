package br.com.itau.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ContaRepository;
import br.com.itau.adapters.out.repository.mapper.ContaEntityMapper;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.ports.out.InserirContaOutputPort;

@Component
public class InserirContaAdapter implements InserirContaOutputPort {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ContaEntityMapper contaEntityMapper;
	
	@Override
	public Conta inserir(Conta conta) {
		
		var contaEntity = contaEntityMapper.toContaEntity(conta);
		var contaSalva = contaRepository.save(contaEntity);
		return contaEntityMapper.toConta(contaSalva);
	}
}
