package br.com.itau.adapters.out.integration.response;

import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import lombok.Data;

@Data
public class ContaResponseIntegration {

	private TipoConta tipoConta;
	private Integer numeroAgencia;
	private Integer numeroConta;
	private String nomeCorrentista;
	private String sobrenomeCorrentista;
	private TipoPessoa tipoPessoa;
	
	@Override
	public String toString() {
		return "ContaResponse [tipoConta=" + tipoConta + ", numeroAgencia=" + numeroAgencia + ", numeroConta=" + numeroConta
				+ ", nomeCorrentista=" + nomeCorrentista + ", sobrenomeCorrentista=" + sobrenomeCorrentista
				+ ", tipoPessoa=" + tipoPessoa + "]";
	}
}
