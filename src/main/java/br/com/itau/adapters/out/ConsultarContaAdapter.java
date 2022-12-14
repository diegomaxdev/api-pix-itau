package br.com.itau.adapters.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ContaCustomRepository;
import br.com.itau.adapters.out.repository.mapper.ContaEntityMapper;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.ports.out.ConsultaContaOutPutPort;

@Component
public class ConsultarContaAdapter implements ConsultaContaOutPutPort{
	
	@Autowired
	private ContaCustomRepository contaCustomRepository;

	@Autowired
	private ContaEntityMapper contaEntityMapper;
	
	@Override
	public List<Conta> consulta(Conta conta) {

		var contaEntity = contaCustomRepository.consulta(conta);
		List<Conta> listaContas = new ArrayList<>();
		contaEntity.stream().forEach(entity -> listaContas.add(contaEntityMapper.toConta(entity)));
		return listaContas;
	}

}
