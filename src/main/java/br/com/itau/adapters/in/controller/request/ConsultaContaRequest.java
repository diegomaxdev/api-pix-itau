package br.com.itau.adapters.in.controller.request;

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
public class ConsultaContaRequest {

	private Integer numeroAgencia;
	
	private Integer numeroConta;
	
	private String nomeCorrentista;
	
	private String sobrenomeCorrentista;
}
