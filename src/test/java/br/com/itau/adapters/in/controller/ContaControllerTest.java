package br.com.itau.adapters.in.controller;

import br.com.itau.adapters.out.repository.ChavePixRepository;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.usecase.AlterarChavePixUseCase;
import br.com.itau.application.ports.in.BuscarChavePixIdInputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ContaControllerTest {

    @InjectMocks
    ContaController contaController;

    @Mock
    private ChavePixRepository chavePixRepository;

    @Mock
    private ChavePixEntityMapper chavePixEntityMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void listaContas() {


    }

    @Test
    void inserir() {
    }
}