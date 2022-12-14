package br.com.itau.application.validator;

import java.util.InputMismatchException;

public class ValidadorCNPJ {

	public static boolean isCNPJValido(String CNPJ) {
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14))
			return (false);

		char penultimoDigito, ultimoDigito;
		int somatoria, i, r, numPosicao, pesoMultiplicador;

		try {
			somatoria = 0;
			pesoMultiplicador = 2;
			for (i = 11; i >= 0; i--) {
				numPosicao = (int) (CNPJ.charAt(i) - 48);
				somatoria = somatoria + (numPosicao * pesoMultiplicador);
				pesoMultiplicador = pesoMultiplicador + 1;
				if (pesoMultiplicador == 10)
					pesoMultiplicador = 2;
			}

			r = somatoria % 11;
			if ((r == 0) || (r == 1))
				penultimoDigito = '0';
			else
				penultimoDigito = (char) ((11 - r) + 48);

			somatoria = 0;
			pesoMultiplicador = 2;
			for (i = 12; i >= 0; i--) {
				numPosicao = (int) (CNPJ.charAt(i) - 48);
				somatoria = somatoria + (numPosicao * pesoMultiplicador);
				pesoMultiplicador = pesoMultiplicador + 1;
				if (pesoMultiplicador == 10)
					pesoMultiplicador = 2;
			}

			r = somatoria % 11;
			if ((r == 0) || (r == 1))
				ultimoDigito = '0';
			else
				ultimoDigito = (char) ((11 - r) + 48);

			if ((penultimoDigito == CNPJ.charAt(12)) && (ultimoDigito == CNPJ.charAt(13)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCNPJ(String CNPJ) {
		// máscara do CNPJ: 99.999.999.9999-99
		return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "."
				+ CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14));
	}

}
