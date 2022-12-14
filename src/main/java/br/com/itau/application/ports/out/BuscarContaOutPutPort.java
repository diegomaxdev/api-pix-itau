package br.com.itau.application.ports.out;

import br.com.itau.application.core.domain.Conta;

public interface BuscarContaOutPutPort {

	Conta buscar(Integer numeroAgencia, Integer numeroConta);
}
