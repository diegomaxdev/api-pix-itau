package br.com.itau.application.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidadorCPFTest {

	private static final String CPF_VALIDO = "68693191624";
	private static final String CPF_INVALIDO = "68693191623";
	private static final String CPF_REPETIDO = "0000000000";
	private static final String CPF_INCOMPLETO = "686931916";

	@Test
	public void validarCPFCorreto() {

		assertTrue(ValidadorCPF.isCPFValido(CPF_VALIDO));
	}

	@Test
	public void validarCPFIncorreto() {

		assertFalse(ValidadorCPF.isCPFValido(CPF_INVALIDO));
	}

	@Test
	public void validarCPFInvalido() {

		assertFalse(ValidadorCPF.isCPFValido(CPF_REPETIDO));
	}

	@Test
	public void validarCPFIncompleto() {

		assertFalse(ValidadorCPF.isCPFValido(CPF_INCOMPLETO));
	}
}

