package br.com.itau.application.core.usecase;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoExcecao;
import br.com.itau.application.exception.ApplicationException;
import br.com.itau.application.ports.out.AlterarChavePixOutPutPort;
import br.com.itau.application.ports.out.ConsultaChavePixOutPutPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ConsultaChavePixUseCaseTest {

    public static final UUID ID = UUID.randomUUID();
    public static final TipoChave TIPO_CHAVE = TipoChave.CPF;
    public static final String CHAVE = "36947077869";
    public static final TipoConta TIPO_CONTA = TipoConta.CORRENTE;
    public static final Integer AGENCIA = 2913;
    public static final Integer CONTA = 53694;
    public static final String NOME_CORRENTISTA = "Diego";
    public static final String SOBRENOME_CORRENTISTA = "Andrade";
    public static final LocalDateTime DATA_INCLUSAO = LocalDateTime.now();

    @InjectMocks
    ConsultaChavePixUseCase consultaChavePixUseCase;

    @Mock
    private ConsultaChavePixOutPutPort consultaChavePixOutPutPort;

    private List<ChavePix> lista;

    private ChavePix chavePix;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarVariaveis();
    }

    @Test
    void consulta() {

        when(consultaChavePixOutPutPort.consulta(chavePix)).thenReturn(lista);
        var listaChaves = consultaChavePixOutPutPort.consulta(chavePix);

        assertNotNull(listaChaves);
        assertTrue(listaChaves.isEmpty());
    }

    private void iniciarVariaveis(){
        lista = new ArrayList<>();
        chavePix = new ChavePix(ID, TIPO_CHAVE, CHAVE, TIPO_CONTA, AGENCIA,
                CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, DATA_INCLUSAO,
                null, null);
    }
}