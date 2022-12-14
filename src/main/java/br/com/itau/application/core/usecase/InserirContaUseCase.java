package br.com.itau.application.core.usecase;

import java.time.LocalDateTime;

import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.ports.in.InserirContaInputPort;
import br.com.itau.application.ports.out.InserirContaOutputPort;

public class InserirContaUseCase implements InserirContaInputPort {

	private final InserirContaOutputPort inserirContaOutputPort;

	public InserirContaUseCase(InserirContaOutputPort inserirContaOutputPort) {
		this.inserirContaOutputPort = inserirContaOutputPort;

	}

	@Override
	public Conta inserir(Conta conta) {

		conta.setDataInclusao(LocalDateTime.now());
		return inserirContaOutputPort.inserir(conta);
	}
}
