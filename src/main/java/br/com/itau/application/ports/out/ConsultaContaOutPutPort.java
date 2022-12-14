package br.com.itau.application.ports.out;

import java.util.List;

import br.com.itau.application.core.domain.Conta;

public interface ConsultaContaOutPutPort {

	List<Conta> consulta(Conta conta);
}
