package br.com.itau.application.ports.in;

import java.util.List;

import br.com.itau.application.core.domain.ChavePix;

public interface ConsultaChavePixInputPort {

	List<ChavePix> consulta(ChavePix chave);
}
