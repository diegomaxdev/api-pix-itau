package br.com.itau.application.exception;

import br.com.itau.application.core.domain.enums.TipoExcecao;

public class ApplicationException extends RuntimeException {

	private TipoExcecao tipoExcecao;

	public ApplicationException(TipoExcecao tipoExcecao) {
		this.tipoExcecao = tipoExcecao;
	}

	public TipoExcecao getTipoExcecao() {
		return tipoExcecao;
	}
}
