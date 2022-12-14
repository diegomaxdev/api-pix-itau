package br.com.itau.application.ports.out;

import java.util.Optional;

import br.com.itau.application.core.domain.ChavePix;

public interface ValidarChavePixOutputPort {

	Optional<ChavePix> validar(String valorChave);

}

