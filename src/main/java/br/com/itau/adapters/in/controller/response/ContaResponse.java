package br.com.itau.adapters.in.controller.response;

import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import lombok.Data;

@Data
public class ContaResponse {
	
	private TipoConta tipoConta;
	private Integer numeroAgencia;
	private Integer numeroConta;
	private String nomeCorrentista;
	private String sobrenomeCorrentista;
	private TipoPessoa tipoPessoa;
}
