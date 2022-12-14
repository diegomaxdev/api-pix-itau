package br.com.itau.application.core.usecase;

import java.util.Optional;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.in.BuscarChavePixValorChaveInputPort;
import br.com.itau.application.ports.out.BuscarChavePixOutPutPort;

public class BuscarChavePixUseCase implements BuscarChavePixValorChaveInputPort {

	private final BuscarChavePixOutPutPort buscarChavePixOutPutPort;

	public BuscarChavePixUseCase(BuscarChavePixOutPutPort buscarChavePixOutPutPort) {
		this.buscarChavePixOutPutPort = buscarChavePixOutPutPort;
	}

	@Override
	public Optional<ChavePix> buscar(String valorChave) {
		
			return buscarChavePixOutPutPort.buscar(valorChave);
	}
}
