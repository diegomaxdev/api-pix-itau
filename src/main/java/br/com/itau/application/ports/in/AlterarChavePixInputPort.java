package br.com.itau.application.ports.in;

import java.util.UUID;

import br.com.itau.application.core.domain.ChavePix;

public interface AlterarChavePixInputPort {

	ChavePix alterar(UUID id, ChavePix chavePix);
}
