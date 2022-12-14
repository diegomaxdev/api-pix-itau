package br.com.itau.application.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;

public class ChavePix {

	private UUID id;
	private TipoChave tipoChave;
	private String valorChave;
	private TipoConta tipoConta;
	private Integer numeroAgencia;
	private Integer numeroConta;
	private String nomeCorrentista;
	private String sobrenomeCorrentista;
	private LocalDateTime dataInclusao;
	private LocalDateTime dataAlteracao;
	private LocalDateTime dataInativacao;

	public ChavePix() {

		this.dataInclusao = LocalDateTime.now();
		this.dataAlteracao = null;
		this.dataInativacao = null;
	}

	public ChavePix(UUID id, TipoChave tipoChave, String valorChave, TipoConta tipoConta, Integer numeroAgencia,
			Integer numeroConta, String nomeCorrentista, String sobrenomeCorrentista, LocalDateTime dataInclusao,
			LocalDateTime dataAlteracao, LocalDateTime dataInativacao) {
		this.id = id;
		this.tipoChave = tipoChave;
		this.valorChave = valorChave;
		this.tipoConta = tipoConta;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.nomeCorrentista = nomeCorrentista;
		this.sobrenomeCorrentista = sobrenomeCorrentista;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.dataInativacao = dataInativacao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public TipoChave getTipoChave() {
		return tipoChave;
	}

	public void setTipoChave(TipoChave tipoChave) {
		this.tipoChave = tipoChave;
	}

	public String getValorChave() {
		return valorChave;
	}

	public void setValorChave(String valorChave) {
		this.valorChave = valorChave;
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

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public LocalDateTime getDataInativacao() {
		return dataInativacao;
	}

	public void setDataInativacao(LocalDateTime dataInativacao) {
		this.dataInativacao = dataInativacao;
	}

}
