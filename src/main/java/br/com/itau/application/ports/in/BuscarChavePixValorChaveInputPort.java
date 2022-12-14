package br.com.itau.application.ports.in;

import java.util.Optional;

import br.com.itau.application.core.domain.ChavePix;

public interface BuscarChavePixValorChaveInputPort {

	Optional<ChavePix> buscar(String valorChave);
}
