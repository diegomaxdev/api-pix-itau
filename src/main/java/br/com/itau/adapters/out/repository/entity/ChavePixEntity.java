package br.com.itau.adapters.out.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "chaves_pix")
public class ChavePixEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	private UUID id;

	@Column(name = "tipo_chave")
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoChave tipoChave;

	@Column(name = "valor_chave")
	@NotNull
	@NotEmpty
	@Size(max = 77)
	private String valorChave;

	@Column(name = "tipo_conta")
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;

	@Column(name = "numero_agencia")
	private Integer numeroAgencia;

	@Column(name = "numero_conta")
	private Integer numeroConta;

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

	@Column(name = "data_alteracao")
	private LocalDateTime dataAlteracao;

	@Column(name = "data_inativacao")
	private LocalDateTime dataInativacao;
	
}
