package br.com.itau.application.core.usecase;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.in.BuscarContaByAgenciaContaInputPort;
import br.com.itau.application.ports.out.AlterarChavePixOutPutPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class AlterarChavePixUseCaseTest {

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
    AlterarChavePixUseCase alterarChavePixUseCase;

    @Mock
    private BuscarChavePixIdInputPort buscarChavePixIdInputPort;

    @Mock
    private AlterarChavePixOutPutPort alterarChavePixOutPutPort;

    @Mock
    private BuscarContaByAgenciaContaInputPort buscarContaAgenciaContaInputPort;
    private UUID id;
    private ChavePix chavePix;

    private Conta conta;

    private Optional<ChavePix> optional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarVariaveis();
    }

    @Test
    void alterar()
    {
        when(alterarChavePixOutPutPort.alterar(chavePix)).thenReturn(chavePix);

        var chaveValida = validar(id, chavePix);
        assertEquals(ChavePix.class, chaveValida.getClass());

        chaveValida.setTipoConta(chavePix.getTipoConta());
        chaveValida.setNomeCorrentista(chavePix.getNomeCorrentista());
        chaveValida.setSobrenomeCorrentista(chavePix.getSobrenomeCorrentista());
        chaveValida.setNumeroAgencia(chavePix.getNumeroAgencia());
        chaveValida.setNumeroConta(chavePix.getNumeroConta());
        chaveValida.setDataAlteracao(LocalDateTime.now());

        var chave = alterarChavePixOutPutPort.alterar(chavePix);
        assertEquals(ChavePix.class, chave.getClass());
        assertNotNull(chave);
        assertEquals(CHAVE, chave.getValorChave());
     }

    @Test
    ChavePix validar(UUID id, ChavePix chavePix)
    {
        when(buscarChavePixIdInputPort.buscar(id)).thenReturn(optional);
        when(buscarContaAgenciaContaInputPort.buscar(anyInt(), anyInt())).thenReturn(conta);

        var opt = buscarChavePixIdInputPort.buscar(id);
        var ct = buscarContaAgenciaContaInputPort.buscar(AGENCIA,CONTA);

        assertEquals(Optional.class, opt.getClass());
        assertEquals(Conta.class, ct.getClass());

        assertNotNull(opt);
        assertNotNull(ct);

        assertEquals(CHAVE, opt.get().getValorChave());
        assertEquals(AGENCIA, ct.getNumeroAgencia());
        assertEquals(CONTA, ct.getNumeroConta());

        return opt.get();
    }


    private void iniciarVariaveis(){
        id = UUID.randomUUID();
        chavePix = new ChavePix(ID, TIPO_CHAVE, CHAVE, TIPO_CONTA, AGENCIA,
                CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, DATA_INCLUSAO,
                null, null);

        optional = Optional.of(new ChavePix(ID, TIPO_CHAVE, CHAVE, TIPO_CONTA, AGENCIA,
                CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, DATA_INCLUSAO,
                null, null));

        conta = new Conta(TIPO_CONTA, AGENCIA, CONTA, NOME_CORRENTISTA,
                SOBRENOME_CORRENTISTA, TipoPessoa.FISICA, DATA_INCLUSAO);

    }
}