package br.com.itau.application.core.usecase;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.Conta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import br.com.itau.application.ports.out.BuscarChavePixAgenciaContaOutPutPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class BuscarChavePixAgenciaContaUseCaseTest {

    public static final Integer AGENCIA = 2913;
    public static final Integer CONTA = 53694;

    @InjectMocks
    BuscarChavePixAgenciaContaUseCase buscarChavePixAgenciaContaUseCase;
    @Mock
    private BuscarChavePixAgenciaContaOutPutPort buscarChavePixAgenciaContaOutPutPort;

    private List<ChavePix> lista;
    private Integer agencia;
    private Integer conta;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarVariaveis();
    }

    @Test
    void buscar() {
        when(buscarChavePixAgenciaContaOutPutPort.buscar(anyInt(), anyInt())).thenReturn(lista);
        var listaChaves = buscarChavePixAgenciaContaOutPutPort.buscar(agencia, conta);

        assertNotNull(listaChaves);
        assertTrue(listaChaves.isEmpty());
    }

    private void iniciarVariaveis(){
        lista = new ArrayList<>();
        agencia = AGENCIA;
        conta = CONTA;
    }
}