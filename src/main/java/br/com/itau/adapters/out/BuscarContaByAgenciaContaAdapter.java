package br.com.itau.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ContaRepository;
import br.com.itau.adapters.out.repository.mapper.ContaEntityMapper;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.ports.out.BuscarContaByAgenciaContaOutPutPort;

@Component
public class BuscarContaByAgenciaContaAdapter implements BuscarContaByAgenciaContaOutPutPort {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ContaEntityMapper contaEntityMapper;

	@Override
	public Conta buscar(Integer numeroAgencia, Integer numeroConta) {

		var conta = contaRepository.findByNumeroAgenciaAndNumeroConta(numeroAgencia, numeroConta);
		return contaEntityMapper.toConta(conta);
	}

}
