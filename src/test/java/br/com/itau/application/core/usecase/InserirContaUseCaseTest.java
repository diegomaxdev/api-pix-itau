package br.com.itau.application.core.usecase;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.out.InserirContaOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class InserirContaUseCaseTest {

	public static final String CHAVE = "36947077869";
	public static final TipoConta TIPO_CONTA = TipoConta.CORRENTE;
	public static final Integer AGENCIA = 2913;
	public static final Integer CONTA = 53694;
	public static final String NOME_CORRENTISTA = "Diego";
	public static final String SOBRENOME_CORRENTISTA = "Andrade";
	public static final LocalDateTime DATA_INCLUSAO = LocalDateTime.now();
	public static final TipoPessoa FISICA = TipoPessoa.FISICA;

	@InjectMocks
	InserirContaUseCase inserirContaUseCase;

	@Mock
	private InserirContaOutputPort inserirContaOutputPort;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		iniciarVariaveis();
	}

	private Conta conta;

	@Test
	void inserir() {
		when(inserirContaOutputPort.inserir(conta)).thenReturn(conta);
		assertEquals(Conta.class, conta.getClass());
		assertNotNull(conta);
		assertEquals(AGENCIA, conta.getNumeroAgencia());
		assertEquals(CONTA, conta.getNumeroConta());
	}

	private void iniciarVariaveis(){
		conta = new Conta(TIPO_CONTA, AGENCIA, CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, FISICA, DATA_INCLUSAO);

	}
	
}
