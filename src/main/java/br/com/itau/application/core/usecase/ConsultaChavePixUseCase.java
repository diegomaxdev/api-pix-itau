package br.com.itau.application.core.usecase;

import java.util.List;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.enums.TipoExcecao;
import br.com.itau.application.exception.ApplicationException;
import br.com.itau.application.ports.in.ConsultaChavePixInputPort;
import br.com.itau.application.ports.out.ConsultaChavePixOutPutPort;

public class ConsultaChavePixUseCase implements ConsultaChavePixInputPort{

	private final ConsultaChavePixOutPutPort consultaChavePixOutPutPort;

	public ConsultaChavePixUseCase(ConsultaChavePixOutPutPort consultaChavePixOutPutPort) {
		this.consultaChavePixOutPutPort = consultaChavePixOutPutPort;
	}
	
	@Override
	public List<ChavePix> consulta(ChavePix chavePix) {
		
		validar(chavePix);
		return consultaChavePixOutPutPort.consulta(chavePix);
	}

	private void validar(ChavePix chavePix) {
		
		if(chavePix.getId() != null && 
				(  chavePix.getTipoChave() != null 
				|| chavePix.getNumeroAgencia() != null
				|| chavePix.getNumeroConta() != null
				|| chavePix.getNomeCorrentista() != null
				|| chavePix.getDataInclusao() != null
				|| chavePix.getDataAlteracao() != null)){
			
			throw new ApplicationException(TipoExcecao.CONSULTA_INVALIDA);	
		}
				
		if(chavePix.getDataInclusao() != null && chavePix.getDataAlteracao() != null){
			throw new ApplicationException(TipoExcecao.CONSULTA_DATAS_INVALIDAS);	
		}
	}
}
