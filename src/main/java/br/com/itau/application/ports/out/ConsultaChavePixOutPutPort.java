package br.com.itau.application.ports.out;

import java.util.List;

import br.com.itau.application.core.domain.ChavePix;

public interface ConsultaChavePixOutPutPort {

	List<ChavePix> consulta(ChavePix chaveChave);
}
