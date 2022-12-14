package br.com.itau.application.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidadorCNPJTest {

	private static final String CNPJ_VALIDO = "64969288000190";
	private static final String CNPJ_INVALIDO = "64969288000175";
	private static final String CNPJ_REPETIDO = "00000000000000";
	private static final String CNPJ_INCOMPLETO = "649692880001";

	@Test
	public void validarCNPJCorreto() {

		assertTrue(ValidadorCNPJ.isCNPJValido(CNPJ_VALIDO));
	}

	@Test
	public void validarCNPJIncorreto() {

		assertFalse(ValidadorCNPJ.isCNPJValido(CNPJ_INVALIDO));
	}

	@Test
	public void validarCNPJInvalido() {

		assertFalse(ValidadorCNPJ.isCNPJValido(CNPJ_REPETIDO));
	}

	@Test
	public void validarCNPJIncompleto() {

		assertFalse(ValidadorCNPJ.isCNPJValido(CNPJ_INCOMPLETO));
	}

}
