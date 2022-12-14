package br.com.itau.application.ports.in;

import br.com.itau.application.core.domain.Conta;

public interface BuscarContaByAgenciaContaInputPort {

	Conta buscar(Integer numeroAgencia, Integer numeroConta);
}
