package br.com.itau.adapters.in.controller.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.core.domain.enums.TipoConta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InserirChavePixRequest {

	@Enumerated(EnumType.STRING) 
	private TipoChave tipoChave;
	
	@NotBlank
	@Size(max = 77)
	private String valorChave;
			
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;
	
	@NotNull
	@Max(9999)
	private Integer numeroAgencia;
	
	@NotNull
	@Max(99999999)
	private Integer numeroConta;
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String nomeCorrentista;
	
	@Size(max = 45)
	private String sobrenomeCorrentista;
}
