package br.com.itau.application.core.usecase;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.out.ConsultaContaOutPutPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class ConsultaContaUseCaseTest {

    public static final TipoConta TIPO_CONTA = TipoConta.CORRENTE;
    public static final Integer AGENCIA = 2913;
    public static final Integer CONTA = 53694;
    public static final String NOME_CORRENTISTA = "Diego";
    public static final String SOBRENOME_CORRENTISTA = "Andrade";
    public static final LocalDateTime DATA_INCLUSAO = LocalDateTime.now();
    public static final TipoPessoa FISICA = TipoPessoa.FISICA;

    @InjectMocks
    ConsultaContaUseCase consultaContaUseCase;

    @Mock
    private ConsultaContaOutPutPort consultaContaOutPutPort;

    private Conta conta;

    private List<Conta> lista;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarVariaveis();
    }

    @Test
    void consulta() {

        when(consultaContaOutPutPort.consulta(conta)).thenReturn(lista);
        var listaContas = consultaContaOutPutPort.consulta(conta);
        assertFalse(lista.isEmpty());
    }

    private void iniciarVariaveis(){
        conta = new Conta(TIPO_CONTA, AGENCIA, CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, FISICA, DATA_INCLUSAO);
        lista = new ArrayList<>();
        lista.add(conta);
    }
}