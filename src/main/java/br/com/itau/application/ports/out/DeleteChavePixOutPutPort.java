package br.com.itau.application.ports.out;

import br.com.itau.application.core.domain.ChavePix;

public interface DeleteChavePixOutPutPort {

	ChavePix delete(ChavePix chavePix);
}
