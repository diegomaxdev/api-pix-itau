package br.com.itau.application.core.usecase;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import br.com.itau.application.ports.in.BuscarChavePixAgenciaContaInputPort;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.in.BuscarChavePixValorChaveInputPort;
import br.com.itau.application.ports.in.BuscarContaByAgenciaContaInputPort;
import br.com.itau.application.ports.out.InserirChavePixOutputPort;
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
import static org.mockito.Mockito.when;

class InserirChavePixUseCaseTest {

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
    InserirChavePixUseCase inserirChavePixUseCase;

    @Mock
    private InserirChavePixOutputPort inserirChavePixOutputPort;
    @Mock
    private BuscarChavePixValorChaveInputPort buscarChavePixValorChaveInputPort;
    @Mock
    private BuscarChavePixAgenciaContaInputPort buscarChavePixAgenciaContaInputPort;
    @Mock
    private BuscarContaByAgenciaContaInputPort buscarContaAgenciaContaInputPort;

    private ChavePix chavePix;
    private Optional<ChavePix> optChavePix;
    private Conta conta;
    private List<ChavePix> listaChaves;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarVariaveis();
    }

    @Test
    void inserir() {

       //validar(chavePix);
        when(inserirChavePixOutputPort.inserir(chavePix)).thenReturn(chavePix);
        var chaveCadastrada = inserirChavePixOutputPort.inserir(chavePix);
        assertEquals(ChavePix.class, chaveCadastrada.getClass());
        assertNotNull(chaveCadastrada);
        assertEquals(CHAVE, chaveCadastrada.getValorChave());
    }





    private void iniciarVariaveis(){
        chavePix = new ChavePix(ID, TIPO_CHAVE, CHAVE, TIPO_CONTA, AGENCIA,
                CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, DATA_INCLUSAO,
                null, null);

        optChavePix = Optional.of(new ChavePix(ID, TIPO_CHAVE, CHAVE, TIPO_CONTA, AGENCIA,
                CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, DATA_INCLUSAO,
                null, null));

        conta = new Conta(TIPO_CONTA, AGENCIA, CONTA, NOME_CORRENTISTA,
                SOBRENOME_CORRENTISTA, TipoPessoa.FISICA, DATA_INCLUSAO);

        listaChaves = new ArrayList<>();
        listaChaves.add(chavePix);
    }
}