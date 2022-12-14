package br.com.itau.application.ports.in;

import br.com.itau.application.core.domain.Conta;

public interface InserirContaInputPort {

	Conta inserir(Conta conta);
}
