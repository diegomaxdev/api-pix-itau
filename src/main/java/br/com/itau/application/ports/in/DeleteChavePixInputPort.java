package br.com.itau.application.ports.in;

import java.util.UUID;

import br.com.itau.application.core.domain.ChavePix;

public interface DeleteChavePixInputPort {

	ChavePix delete(UUID id);
}
