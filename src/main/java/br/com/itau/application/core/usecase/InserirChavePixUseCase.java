package br.com.itau.application.core.usecase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoExcecao;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import br.com.itau.application.exception.ApplicationException;
import br.com.itau.application.ports.in.BuscarChavePixAgenciaContaInputPort;
import br.com.itau.application.ports.in.BuscarChavePixValorChaveInputPort;
import br.com.itau.application.ports.in.BuscarContaByAgenciaContaInputPort;
import br.com.itau.application.ports.in.InserirChavePixInputPort;
import br.com.itau.application.ports.out.InserirChavePixOutputPort;
import br.com.itau.application.validator.ValidadorCNPJ;
import br.com.itau.application.validator.ValidadorCPF;

public class InserirChavePixUseCase implements InserirChavePixInputPort {

	private Pattern pattern = null;
	private Matcher match = null;

	private final InserirChavePixOutputPort inserirChavePixOutputPort;
	private final BuscarChavePixValorChaveInputPort buscarChavePixValorChaveInputPort;
	private final BuscarChavePixAgenciaContaInputPort buscarChavePixAgenciaContaInputPort;
	private final BuscarContaByAgenciaContaInputPort buscarContaAgenciaContaInputPort;

	public InserirChavePixUseCase(BuscarChavePixValorChaveInputPort buscarChavePixValorChaveInputPort,
			InserirChavePixOutputPort inserirChavePixOutputPort,
			BuscarChavePixAgenciaContaInputPort buscarChavePixAgenciaContaInputPort,
			BuscarContaByAgenciaContaInputPort buscarContaAgenciaContaInputPort) {
		this.buscarChavePixValorChaveInputPort = buscarChavePixValorChaveInputPort;
		this.inserirChavePixOutputPort = inserirChavePixOutputPort;
		this.buscarChavePixAgenciaContaInputPort = buscarChavePixAgenciaContaInputPort;
		this.buscarContaAgenciaContaInputPort = buscarContaAgenciaContaInputPort;
	}

	@Override
	public ChavePix inserir(ChavePix chavePix) {

		validar(chavePix);
		return inserirChavePixOutputPort.inserir(chavePix);
	}

	private void validar(ChavePix chavePix) {

		var chaveExiste = buscarChavePixValorChaveInputPort.buscar(chavePix.getValorChave());
		if (chaveExiste.isPresent()) {
			throw new ApplicationException(TipoExcecao.TIPO_CHAVE_JA_CADASTRADA);
		}

		/******* Via API Mock - Feign
		var conta = complementoContaOutPutPort.executar(chavePix.getNumeroAgencia(),chavePix.getNumeroConta());
		*********/
	
		var conta = buscarContaAgenciaContaInputPort.buscar(chavePix.getNumeroAgencia(), chavePix.getNumeroConta());
		if(conta == null){
			throw new ApplicationException(TipoExcecao.CONTA_SEM_CADASTRO);
		}
			
		var listaChaves = buscarChavePixAgenciaContaInputPort.buscar(chavePix.getNumeroAgencia(),chavePix.getNumeroConta());
		if (conta.getTipoPessoa().equals(TipoPessoa.FISICA) && listaChaves.size() >= 5) {
			throw new ApplicationException(TipoExcecao.LIMITE_DE_CHAVE_FISICA_JA_CADASTRADA);
		}

		if (conta.getTipoPessoa().equals(TipoPessoa.JURIDICA) && listaChaves.size() >= 20) {
			throw new ApplicationException(TipoExcecao.LIMITE_DE_CHAVE_JURIDICA_JA_CADASTRADA);
		}

		switch (chavePix.getTipoChave()) {
		case CPF:
			validarCpf(chavePix.getValorChave());
			break;
		case CNPJ:
			validarCnpj(chavePix.getValorChave());
			break;
		case CELULAR:
			validarCelular(chavePix.getValorChave());
			break;
		case EMAIL:
			validarEmail(chavePix.getValorChave());
			break;
		case ALEATORIA:
			ValidarAleatoria(chavePix.getValorChave());
			break;
		default:
			throw new ApplicationException(TipoExcecao.TIPO_CHAVE_INVALIDA);
		}
	}

	private void ValidarAleatoria(String valorChave) {

		if (valorChave.trim().length() > 36) {

			throw new ApplicationException(TipoExcecao.ALEATORIA_TAMANHO);
		}

		pattern = Pattern.compile(TipoChave.ALEATORIA.regex);
		match = pattern.matcher(valorChave);

		if (!match.matches()) {
			throw new ApplicationException(TipoExcecao.ALEATORIA_INVALIDA);
		}
	}

	private void validarEmail(String valorChave) {

		if (valorChave.trim().length() > 77) {

			throw new ApplicationException(TipoExcecao.EMAIL_TAMANHO);
		}

		if (valorChave.trim().contentEquals("@")) {

			throw new ApplicationException(TipoExcecao.EMAIL_INCORRETO);
		}

		pattern = Pattern.compile(TipoChave.EMAIL.regex);
		match = pattern.matcher(valorChave);

		if (!match.matches()) {
			throw new ApplicationException(TipoExcecao.EMAIL_INVALIDO);
		}
	}

	private void validarCelular(String valorChave) {

		if (!valorChave.trim().startsWith("+")) {

			throw new ApplicationException(TipoExcecao.CELULAR_INICIO_INVALIDO);
		}

		if (valorChave.trim().trim().length() < 12 || valorChave.trim().trim().length() > 15) {

			throw new ApplicationException(TipoExcecao.CELULAR_TAMANHO);
		}

		String celularNumerico = valorChave.replace("+", "");
		// VALIDANDO CARACTERES ESPECIAIS ATRAVES DO LAMBDA
		if (!celularNumerico.chars().allMatch(Character::isDigit)) {

			throw new ApplicationException(TipoExcecao.CELULAR_NAO_NUMERICO);
		}

		// VALIDANDO VIA REGEX PARA GARANTIR QUE O EMAIL ESTÀ CORRETO
		pattern = Pattern.compile(TipoChave.CELULAR.regex);
		match = pattern.matcher(valorChave);

		if (!match.matches()) {
			throw new ApplicationException(TipoExcecao.CELULAR_INVALIDO);
		}
	}

	private void validarCnpj(String valorChave) {

		if (valorChave.trim().length() != 14) {

			throw new ApplicationException(TipoExcecao.CNPJ_TAMANHO);
		}

		if (!valorChave.chars().allMatch(Character::isDigit)) {

			throw new ApplicationException(TipoExcecao.CNPJ_NAO_NUMERICO);
		}

		pattern = Pattern.compile(TipoChave.CNPJ.regex);
		match = pattern.matcher(valorChave);

		if (!match.matches()) {
			throw new ApplicationException(TipoExcecao.CNPJ_INVALIDO);
		}

		if (!ValidadorCNPJ.isCNPJValido(valorChave)) {

			throw new ApplicationException(TipoExcecao.CNPJ_NUMERO_INVALIDO);
		}
	}

	private void validarCpf(String valorChave) {

		if (valorChave.trim().length() != 11) {

			throw new ApplicationException(TipoExcecao.CPF_TAMANHO);
		}

		if (!valorChave.chars().allMatch(Character::isDigit)) {

			throw new ApplicationException(TipoExcecao.CPF_NAO_NUMERICO);
		}

		pattern = Pattern.compile(TipoChave.CPF.regex);
		match = pattern.matcher(valorChave);

		if (!match.matches()) {

			throw new ApplicationException(TipoExcecao.CPF_INVALIDO);
		}

		if (!ValidadorCPF.isCPFValido(valorChave)) {

			throw new ApplicationException(TipoExcecao.CPF_NUMERO_INVALIDO);
		}
	}
}
