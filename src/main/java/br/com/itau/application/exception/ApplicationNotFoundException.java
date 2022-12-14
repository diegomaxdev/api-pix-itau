package br.com.itau.application.exception;

import br.com.itau.application.core.domain.enums.TipoExcecao;

public class ApplicationNotFoundException extends RuntimeException {

	private TipoExcecao tipoExcecao;

	public ApplicationNotFoundException(TipoExcecao tipoExcecao) {
		this.tipoExcecao = tipoExcecao;
	}

	public TipoExcecao getTipoExcecao() {
		return tipoExcecao;
	}
}
