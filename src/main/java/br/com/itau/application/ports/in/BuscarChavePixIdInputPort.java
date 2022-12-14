package br.com.itau.application.ports.in;

import java.util.Optional;
import java.util.UUID;

import br.com.itau.application.core.domain.ChavePix;

public interface BuscarChavePixIdInputPort {

	Optional<ChavePix> buscar(UUID id);
}
