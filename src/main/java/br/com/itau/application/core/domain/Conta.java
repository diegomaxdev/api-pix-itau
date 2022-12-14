package br.com.itau.application.core.domain;

import java.time.LocalDateTime;

import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;

public class Conta {

	private TipoConta tipoConta;
	private Integer numeroAgencia;
	private Integer numeroConta;
	private String nomeCorrentista;
	private String sobrenomeCorrentista;
	private TipoPessoa tipoPessoa;
	private LocalDateTime dataInclusao;

	public Conta() {
	}

	public Conta(TipoConta tipoConta, Integer numeroAgencia, Integer numeroConta, String nomeCorrentista,
			String sobrenomeCorrentista, TipoPessoa tipoPessoa, LocalDateTime dataInclusao) {
		super();
		this.tipoConta = tipoConta;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.nomeCorrentista = nomeCorrentista;
		this.sobrenomeCorrentista = sobrenomeCorrentista;
		this.tipoPessoa = tipoPessoa;
		this.dataInclusao = dataInclusao;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeCorrentista() {
		return nomeCorrentista;
	}

	public void setNomeCorrentista(String nomeCorrentista) {
		this.nomeCorrentista = nomeCorrentista;
	}

	public String getSobrenomeCorrentista() {
		return sobrenomeCorrentista;
	}

	public void setSobrenomeCorrentista(String sobrenomeCorrentista) {
		this.sobrenomeCorrentista = sobrenomeCorrentista;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
}
