package br.com.itau.application.core.usecase;

import java.util.Optional;
import java.util.UUID;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.out.BuscarChavePixIdOutPutPort;

public class BuscarChavePixIdUseCase implements BuscarChavePixIdInputPort {

	private final BuscarChavePixIdOutPutPort buscarChavePixIdOutPutPort;

	public BuscarChavePixIdUseCase(BuscarChavePixIdOutPutPort buscarChavePixIdOutPutPort) {
		this.buscarChavePixIdOutPutPort = buscarChavePixIdOutPutPort;
	}

	@Override
	public Optional<ChavePix> buscar(UUID id) {
		
		return buscarChavePixIdOutPutPort.buscar(id);
	}
}
