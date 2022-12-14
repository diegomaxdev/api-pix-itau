package br.com.itau.application.ports.out;

import br.com.itau.application.core.domain.Conta;

public interface ComplementoContaOutPutPort {

	Conta executar(Integer numeroAgencia, Integer numeroConta);
}
