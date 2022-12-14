package br.com.itau.adapters.in.controller.request;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.itau.application.core.domain.enums.TipoChave;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaChavePixRequest {
	
	private UUID id;

	private TipoChave tipoChave;
	
	private Integer numeroAgencia;
	
	private Integer numeroConta;
	
	private String nomeCorrentista;
	
	private LocalDateTime dataInclusao;

	private LocalDateTime dataAlteracao;
}
