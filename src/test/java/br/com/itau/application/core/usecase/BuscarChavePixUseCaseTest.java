package br.com.itau.application.core.usecase;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.out.BuscarChavePixOutPutPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class BuscarChavePixUseCaseTest {
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
    BuscarChavePixUseCase buscarChavePixUseCase;

    @Mock
    private BuscarChavePixOutPutPort buscarChavePixOutPutPort;

    private Optional<ChavePix> optional;

    private String chave;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarVariaveis();
    }

    @Test
    void buscar() {
        when(buscarChavePixOutPutPort.buscar(anyString())).thenReturn(optional);
        var opt = buscarChavePixOutPutPort.buscar(chave);
        assertEquals(Optional.class, opt.getClass());
        assertNotNull(opt);
        assertEquals(CHAVE, opt.get().getValorChave());
    }

    private void iniciarVariaveis(){
        chave = "36947077869";
        optional = Optional.of(new ChavePix(ID, TIPO_CHAVE, CHAVE, TIPO_CONTA, AGENCIA,
                CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, DATA_INCLUSAO,
                null, null));
    }
}