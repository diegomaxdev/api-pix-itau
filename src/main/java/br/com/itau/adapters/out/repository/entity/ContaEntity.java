package br.com.itau.adapters.out.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.itau.application.core.domain.enums.TipoConta;
import br.com.itau.application.core.domain.enums.TipoPessoa;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "conta")
public class ContaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "numero_agencia")
	private Integer numeroAgencia;

	@Column(name = "numero_conta")
	private Integer numeroConta;
	
	@Column(name = "tipo_conta")
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;

	@Column(name = "nome_correntista")
	@NotNull
	@NotEmpty
	@Size(max = 30)
	private String nomeCorrentista;

	@Column(name = "sobrenome_correntista")
	@Size(max = 45)
	private String sobrenomeCorrentista;

	@Column(name = "data_inclusao")
	private LocalDateTime dataInclusao;

	@Column(name = "tipo_pessoa")
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

	@Override
	public String toString() {
		return "ContaEntity [id=" + id + ", numeroAgencia=" + numeroAgencia + ", numeroConta=" + numeroConta
				+ ", tipoConta=" + tipoConta + ", nomeCorrentista=" + nomeCorrentista + ", sobrenomeCorrentista="
				+ sobrenomeCorrentista + ", dataInclusao=" + dataInclusao + ", tipoPessoa=" + tipoPessoa + "]";
	}
}
