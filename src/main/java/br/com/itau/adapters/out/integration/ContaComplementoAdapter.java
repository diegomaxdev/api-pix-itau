package br.com.itau.adapters.out.integration;

import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.integration.client.ContaComplementoClient;
import br.com.itau.adapters.out.integration.mapper.ContaComplementoMapper;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.ports.out.ComplementoContaOutPutPort;

@Component
public class ContaComplementoAdapter implements ComplementoContaOutPutPort {

	private final ContaComplementoClient contaComplementoClient;
	private final ContaComplementoMapper contaComplementoMapper;
	
	public ContaComplementoAdapter(ContaComplementoClient contaComplementoClient,
			ContaComplementoMapper contaIntegrationMapper) {
		this.contaComplementoClient = contaComplementoClient;
		this.contaComplementoMapper = contaIntegrationMapper;
	}

	@Override
	public Conta executar(Integer numeroAgencia, Integer numeroConta) {
		System.out.println(contaComplementoClient.getConta(numeroAgencia, numeroConta));
		var contaResponse = contaComplementoClient.getConta(numeroAgencia, numeroConta);
		System.out.println(contaResponse);
		return contaComplementoMapper.toConta(contaResponse);
	}

}
