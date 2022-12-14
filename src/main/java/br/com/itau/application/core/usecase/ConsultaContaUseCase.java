package br.com.itau.application.core.usecase;

import java.util.List;

import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.ports.in.ConsultaContaInputPort;
import br.com.itau.application.ports.out.ConsultaContaOutPutPort;

public class ConsultaContaUseCase implements ConsultaContaInputPort{

	private final ConsultaContaOutPutPort consultaContaOutPutPort;

	public ConsultaContaUseCase(ConsultaContaOutPutPort consultaContaOutPutPort) {
		this.consultaContaOutPutPort = consultaContaOutPutPort;
	}
	
	@Override
	public List<Conta> consulta(Conta conta) {

		return consultaContaOutPutPort.consulta(conta);
	}
}
