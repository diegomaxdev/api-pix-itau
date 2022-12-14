package br.com.itau.adapters.in.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.adapters.in.controller.mapper.ContaControllerMapper;
import br.com.itau.adapters.in.controller.request.ConsultaContaRequest;
import br.com.itau.adapters.in.controller.request.InserirContaRequest;
import br.com.itau.adapters.in.controller.response.ContaResponse;
import br.com.itau.application.ports.in.ConsultaContaInputPort;
import br.com.itau.application.ports.in.InserirContaInputPort;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pix/contas")
public class ContaController {
	
	private static Logger logger = LoggerFactory.getLogger(ContaController.class);
	
	@Autowired
	private InserirContaInputPort inserirContaInputPort;
	
	@Autowired
	private ConsultaContaInputPort consultaContaInputPort;
	
	@Autowired
	private ContaControllerMapper contaControllerMapper;
	
	@GetMapping("/consulta")
	@Operation(summary = "Consultar Lista de Chavee Pix")
	public ResponseEntity<Object> listaContas(
			@RequestParam(value="Agencia", required=false) Integer numeroAgencia,  
			@RequestParam(value="Conta", required=false) Integer numeroConta, 
			@RequestParam(value="Nome Correntista", required=false) String nomeCorrentista,
			@RequestParam(value="Sobrenome Correntista", required=false) String sobrenomeCorrentista)
	{
		
		logger.info("Consultando Lista de Contas ");
		
		ConsultaContaRequest requestConsulta = new ConsultaContaRequest().builder()
				.numeroAgencia(numeroAgencia)
				.numeroConta(numeroConta)
				.nomeCorrentista(nomeCorrentista)
				.build();
		
		
		var contaEntity = contaControllerMapper.toConta(requestConsulta);		
		var contas = consultaContaInputPort.consulta(contaEntity);
		
		if(contas.isEmpty()) {
			
			return new ResponseEntity<Object>("Não há resultados para esta consulta de Contas", HttpStatus.NOT_FOUND);
		}
		
		List<ContaResponse> response = new ArrayList<>();
		contas.stream().forEach(ct -> response.add(contaControllerMapper.toContaResponse(ct)));
		return ResponseEntity.ok().body(response);
	}
	
		
	@PostMapping
	@Operation(summary = "Inserir Conta")
	public ResponseEntity<ContaResponse> inserir(@Valid @RequestBody  InserirContaRequest inserirContaRequest){

		logger.info("Salvando a Conta " + inserirContaRequest);
		var conta = contaControllerMapper.toConta(inserirContaRequest);
		var chavePixResponse = contaControllerMapper.toContaResponse(inserirContaInputPort.inserir(conta));
		return ResponseEntity.ok().body(chavePixResponse);
	}
}
