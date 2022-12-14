package br.com.itau.application.ports.out;

import java.util.Optional;
import java.util.UUID;

import br.com.itau.application.core.domain.ChavePix;

public interface BuscarChavePixIdOutPutPort {

	Optional<ChavePix> buscar(UUID id);
}
