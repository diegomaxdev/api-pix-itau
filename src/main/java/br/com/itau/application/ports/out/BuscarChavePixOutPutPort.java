package br.com.itau.application.ports.out;

import java.util.Optional;

import br.com.itau.application.core.domain.ChavePix;

public interface BuscarChavePixOutPutPort {

	Optional<ChavePix> buscar(String valorChave);
}
