package br.com.itau.application.ports.out;

import br.com.itau.application.core.domain.Conta;

public interface InserirContaOutputPort {

	Conta inserir(Conta conta);
}
