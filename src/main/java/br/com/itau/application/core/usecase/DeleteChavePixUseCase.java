package br.com.itau.application.core.usecase;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.enums.TipoExcecao;
import br.com.itau.application.exception.ApplicationException;
import br.com.itau.application.exception.ApplicationNotFoundException;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.in.DeleteChavePixInputPort;
import br.com.itau.application.ports.out.DeleteChavePixOutPutPort;

public class DeleteChavePixUseCase implements DeleteChavePixInputPort {

	private final BuscarChavePixIdInputPort buscarChavePixIdInputPort;

	private final DeleteChavePixOutPutPort deleteChavePixOutPutPort;

	public DeleteChavePixUseCase(BuscarChavePixIdInputPort buscarChavePixIdInputPort,
			DeleteChavePixOutPutPort deleteChavePixOutPutPort) {
		this.buscarChavePixIdInputPort = buscarChavePixIdInputPort;
		this.deleteChavePixOutPutPort = deleteChavePixOutPutPort;
	}

	@Override
	public ChavePix delete(UUID id) {

		var chaveValida =  validar(id);
		chaveValida.setDataInativacao(LocalDateTime.now());
		deleteChavePixOutPutPort.delete(chaveValida);
		
		return chaveValida;
	}

	private ChavePix validar(UUID id) {
		
		var chaveExistente = buscarChavePixIdInputPort.buscar(id);
		
		if (!chaveExistente.isPresent()) {
			throw new ApplicationNotFoundException(TipoExcecao.CHAVE_NAO_LOCALIZADA);
		}

		if (chaveExistente.get().getDataInativacao() != null) {
			throw new ApplicationException(TipoExcecao.CHAVE_DESATIVADA);
		}
		
		return chaveExistente.get();
	}
}
