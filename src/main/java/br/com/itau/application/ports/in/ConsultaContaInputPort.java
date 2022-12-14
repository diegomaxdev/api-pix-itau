package br.com.itau.application.ports.in;

import java.util.List;

import br.com.itau.application.core.domain.Conta;

public interface ConsultaContaInputPort {

	List<Conta> consulta(Conta conta);
}
