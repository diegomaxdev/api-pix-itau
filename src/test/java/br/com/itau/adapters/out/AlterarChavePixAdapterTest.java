package br.com.itau.adapters.out;

import br.com.itau.adapters.out.repository.ChavePixRepository;
import br.com.itau.adapters.out.repository.entity.ChavePixEntity;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AlterarChavePixAdapterTest {

    public static final UUID ID = UUID.randomUUID();
    public static final TipoChave TIPO_CHAVE = TipoChave.CPF;
    public static final String CHAVE = "36947077869";
    public static final TipoConta TIPO_CONTA = TipoConta.CORRENTE;
    public static final Integer AGENCIA = 2913;
    public static final Integer CONTA = 53694;
    public static final String NOME_CORRENTISTA = "Diego";
    public static final String SOBRENOME_CORRENTISTA = "Andrade";
    public static final LocalDateTime DATA_INCLUSAO = LocalDateTime.now();

    @Mock
    private ChavePixRepository chavePixRepository;

    @Mock
    private ChavePixEntityMapper chavePixEntityMapper;

    private ChavePix chavePix;
    private ChavePixEntity chavePixEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarVariaveis();
    }

    @Test
    void alterar() {

        when(chavePixEntityMapper.toChavePixEntity(chavePix)).thenReturn(chavePixEntity);
        chavePixEntity = chavePixEntityMapper.toChavePixEntity(chavePix);

        /*assertEquals(ChavePixEntity.class, chavePixEntity.getClass());
        assertNotNull(chavePixEntity);
        assertEquals(CHAVE, chavePixEntity.getValorChave());*/

        when(chavePixRepository.save(chavePixEntity)).thenReturn(chavePixEntity);
        when(chavePixEntityMapper.toChavePix(chavePixEntity)).thenReturn(chavePix);
        var chave = chavePixEntityMapper.toChavePix(chavePixRepository.save(chavePixEntity));

        assertEquals(ChavePix.class, chave.getClass());
        assertNotNull(chave);
        assertEquals(CHAVE, chave.getValorChave());
    }

    private void iniciarVariaveis(){
         chavePix = new ChavePix(ID, TIPO_CHAVE, CHAVE, TIPO_CONTA, AGENCIA,
                CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, DATA_INCLUSAO,
                null, null);

       /*1chavePixEntity = new ChavePixEntity(ID, TIPO_CHAVE, CHAVE, TIPO_CONTA, AGENCIA,
                CONTA, NOME_CORRENTISTA, SOBRENOME_CORRENTISTA, DATA_INCLUSAO,
                null, null);*/
    }
}