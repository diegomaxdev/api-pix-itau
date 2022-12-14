package br.com.itau.application.core.usecase;

import java.util.List;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.in.BuscarChavePixAgenciaContaInputPort;
import br.com.itau.application.ports.out.BuscarChavePixAgenciaContaOutPutPort;

public class BuscarChavePixAgenciaContaUseCase implements BuscarChavePixAgenciaContaInputPort {

	private final BuscarChavePixAgenciaContaOutPutPort buscarChavePixAgenciaContaOutPutPort;

	public BuscarChavePixAgenciaContaUseCase(
			BuscarChavePixAgenciaContaOutPutPort buscarChavePixAgenciaContaOutPutPort) {
		this.buscarChavePixAgenciaContaOutPutPort = buscarChavePixAgenciaContaOutPutPort;
	}

	@Override
	public List<ChavePix> buscar(Integer numeroAgencia, Integer numeroConta) {
		return buscarChavePixAgenciaContaOutPutPort.buscar(numeroAgencia, numeroConta);
	}
}
