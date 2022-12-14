package br.com.itau.adapters.in.controller.response;

import java.util.UUID;

import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;
import lombok.Data;

@Data
public class ChavePixResponse {

	private UUID id;
	private TipoChave tipoChave;
	private String valorChave;
	private TipoConta tipoConta;
	private Integer numeroAgencia;
	private Integer numeroConta;
	private String nomeCorrentista;
	private String sobrenomeCorrentista;
	private String dataInclusao;
	private String dataAlteracao;
}
