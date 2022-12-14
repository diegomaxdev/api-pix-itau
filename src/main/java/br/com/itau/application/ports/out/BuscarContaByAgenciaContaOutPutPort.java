package br.com.itau.application.ports.out;

import br.com.itau.application.core.domain.Conta;

public interface BuscarContaByAgenciaContaOutPutPort {

	Conta buscar(Integer numeroAgencia, Integer numeroConta);
}
