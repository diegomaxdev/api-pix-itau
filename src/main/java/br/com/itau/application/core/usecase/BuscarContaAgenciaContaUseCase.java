package br.com.itau.application.core.usecase;

import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.ports.in.BuscarContaByAgenciaContaInputPort;
import br.com.itau.application.ports.out.BuscarContaByAgenciaContaOutPutPort;

public class BuscarContaAgenciaContaUseCase implements BuscarContaByAgenciaContaInputPort {

	private final BuscarContaByAgenciaContaOutPutPort buscarContaByAgenciaContaOutPutPort;

	public BuscarContaAgenciaContaUseCase(BuscarContaByAgenciaContaOutPutPort buscarContaByAgenciaContaOutPutPort) {
		this.buscarContaByAgenciaContaOutPutPort = buscarContaByAgenciaContaOutPutPort;
	}

	@Override
	public Conta buscar(Integer numeroAgencia, Integer numeroConta) {
		return buscarContaByAgenciaContaOutPutPort.buscar(numeroAgencia, numeroConta);
	}
}
