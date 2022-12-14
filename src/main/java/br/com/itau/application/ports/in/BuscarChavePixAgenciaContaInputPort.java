package br.com.itau.application.ports.in;

import java.util.List;

import br.com.itau.application.core.domain.ChavePix;

public interface BuscarChavePixAgenciaContaInputPort {

	List<ChavePix> buscar(Integer numeroAgencia, Integer numeroConta);
}
