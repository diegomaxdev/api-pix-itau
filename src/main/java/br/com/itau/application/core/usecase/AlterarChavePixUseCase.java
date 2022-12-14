package br.com.itau.application.core.usecase;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.enums.TipoExcecao;
import br.com.itau.application.exception.ApplicationException;
import br.com.itau.application.exception.ApplicationNotFoundException;
import br.com.itau.application.ports.in.AlterarChavePixInputPort;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.in.BuscarContaByAgenciaContaInputPort;
import br.com.itau.application.ports.out.AlterarChavePixOutPutPort;

public class AlterarChavePixUseCase implements AlterarChavePixInputPort {

	private final BuscarChavePixIdInputPort buscarChavePixIdInputPort;
	private final AlterarChavePixOutPutPort alterarChavePixOutPutPort;
	private final BuscarContaByAgenciaContaInputPort buscarContaAgenciaContaInputPort;
	
	public AlterarChavePixUseCase(BuscarChavePixIdInputPort buscarChavePixIdInputPort,
			AlterarChavePixOutPutPort alterarChavePixOutPutPort,
			BuscarContaByAgenciaContaInputPort buscarContaAgenciaContaInputPort) {
		this.buscarChavePixIdInputPort = buscarChavePixIdInputPort;
		this.alterarChavePixOutPutPort = alterarChavePixOutPutPort;
		this.buscarContaAgenciaContaInputPort = buscarContaAgenciaContaInputPort;
	}

	@Override
	public ChavePix alterar(UUID id, ChavePix chavePix) {

		var chaveValida = validar(id, chavePix);
		chaveValida.setTipoConta(chavePix.getTipoConta());
		chaveValida.setNomeCorrentista(chavePix.getNomeCorrentista());
		chaveValida.setSobrenomeCorrentista(chavePix.getSobrenomeCorrentista());
		chaveValida.setNumeroAgencia(chavePix.getNumeroAgencia()); 
		chaveValida.setNumeroConta(chavePix.getNumeroConta());
		chaveValida.setDataAlteracao(LocalDateTime.now());

		return alterarChavePixOutPutPort.alterar(chaveValida);
	}

	private ChavePix validar(UUID id, ChavePix chavePix) {
		
		var chaveExistente = buscarChavePixIdInputPort.buscar(id);
		if(!chaveExistente.isPresent()) {
			
			throw new ApplicationNotFoundException(TipoExcecao.CHAVE_NAO_LOCALIZADA);
		}
		
		if(chaveExistente.get().getDataInativacao() != null) {
			
			throw new ApplicationException(TipoExcecao.CHAVE_DESATIVADA);
		}
		
		var conta = buscarContaAgenciaContaInputPort.buscar(chavePix.getNumeroAgencia(), chavePix.getNumeroConta());
		if(conta == null){
			throw new ApplicationException(TipoExcecao.CONTA_SEM_CADASTRO);
		}
				
		return chaveExistente.get();
	}
}
