package br.com.itau.application.validator;

import java.util.InputMismatchException;

public class ValidadorCPF {

	public static boolean isCPFValido(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char penultimoDigito, ultimoDigito;
		int somatoria, i, r, numPosicao, pesoMultiplicador;

		try {
			// Calculo do 1o. Digito Verificador
			somatoria = 0;
			pesoMultiplicador = 10;
			for (i = 0; i < 9; i++) {
				numPosicao = (int) (CPF.charAt(i) - 48);
				somatoria = somatoria + (numPosicao * pesoMultiplicador);
				pesoMultiplicador = pesoMultiplicador - 1;
			}

			r = 11 - (somatoria % 11);
			if ((r == 10) || (r == 11))
				penultimoDigito = '0';
			else
				penultimoDigito = (char) (r + 48);

			// Calculo do 2o. Digito Verificador
			somatoria = 0;
			pesoMultiplicador = 11;
			for (i = 0; i < 10; i++) {
				numPosicao = (int) (CPF.charAt(i) - 48);
				somatoria = somatoria + (numPosicao * pesoMultiplicador);
				pesoMultiplicador = pesoMultiplicador - 1;
			}

			r = 11 - (somatoria % 11);
			if ((r == 10) || (r == 11))
				ultimoDigito = '0';
			else
				ultimoDigito = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((penultimoDigito == CPF.charAt(9)) && (ultimoDigito == CPF.charAt(10)))
				return (true);
			else
				return (false);
			
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
}