package br.com.itau.adapters.in.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.adapters.in.controller.mapper.ChavePixControllerMapper;
import br.com.itau.adapters.in.controller.request.AlterarChavePixRequest;
import br.com.itau.adapters.in.controller.request.ConsultaChavePixRequest;
import br.com.itau.adapters.in.controller.request.InserirChavePixRequest;
import br.com.itau.adapters.in.controller.response.ChavePixConsultaResponse;
import br.com.itau.adapters.in.controller.response.ChavePixDeleteResponse;
import br.com.itau.adapters.in.controller.response.ChavePixResponse;
import br.com.itau.application.core.domain.enums.TipoChave;
import br.com.itau.application.ports.in.AlterarChavePixInputPort;
import br.com.itau.application.ports.in.BuscarChavePixValorChaveInputPort;
import br.com.itau.application.ports.in.ConsultaChavePixInputPort;
import br.com.itau.application.ports.in.DeleteChavePixInputPort;
import br.com.itau.application.ports.in.InserirChavePixInputPort;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pix/chaves")
public class ChavePixController {

	private static Logger logger = LoggerFactory.getLogger(ChavePixController.class);

	@Autowired
	private InserirChavePixInputPort inserirChavePixInputPort;

	@Autowired
	private BuscarChavePixValorChaveInputPort buscarChavePixValorChaveInputPort;

	@Autowired
	private ConsultaChavePixInputPort consultaChavePixInputPort;

	@Autowired
	private AlterarChavePixInputPort alterarChavePixInputPort;

	@Autowired
	private DeleteChavePixInputPort deleteChavePixInputPort;

	@Autowired
	private ChavePixControllerMapper chavePixControllerMapper;

	@GetMapping("/consulta")
	@Operation(summary = "Consultar Lista de Chavee Pix")
	public ResponseEntity<Object> listaChavePix(@RequestParam(value = "Id", required = false) UUID id,
			@RequestParam(value = "Tipo Chave", required = false) TipoChave tipoChave,
			@RequestParam(value = "Agencia", required = false) Integer numeroAgencia,
			@RequestParam(value = "Conta", required = false) Integer numeroConta,
			@RequestParam(value = "Nome Correntista", required = false) String nomeCorrentista,
			@RequestParam(value = "Data Inclusão", required = false) LocalDateTime dataInclusao,
			@RequestParam(value = "Data Inativação", required = false) LocalDateTime dataAlteracao) {

		logger.info("Consultando Lista de chaves pela busca Opcional ");

		ConsultaChavePixRequest requestConsulta = new ConsultaChavePixRequest().builder().id(id).tipoChave(tipoChave)
				.numeroAgencia(numeroAgencia).numeroConta(numeroConta).nomeCorrentista(nomeCorrentista)
				.dataInclusao(dataInclusao).dataAlteracao(dataAlteracao).build();

		var chave = chavePixControllerMapper.toChavePixConsulta(requestConsulta);
		var chavesPix = consultaChavePixInputPort.consulta(chave);
		if (chavesPix.isEmpty())
			return new ResponseEntity<Object>("Não há resultados para esta consulta", HttpStatus.NOT_FOUND);
		List<ChavePixConsultaResponse> response = new ArrayList<>();
		chavesPix.stream().forEach(ch -> response.add(chavePixControllerMapper.toChavePixConsultaResponse(ch)));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/consulta/{valorChave}")
	@Operation(summary = "Consultando a Chave Pix pelo valor Chave")
	public ResponseEntity<ChavePixConsultaResponse> buscarValorChave(@PathVariable final String valorChave) {

		logger.info("Consultando a chave " + valorChave);
		var chavePix = buscarChavePixValorChaveInputPort.buscar(valorChave);
		if (!chavePix.isPresent())
			return ResponseEntity.notFound().build();
		var chavePixConsultaResponse = chavePixControllerMapper.toChavePixConsultaResponse(chavePix.get());
		return ResponseEntity.ok().body(chavePixConsultaResponse);
	}

	@PostMapping
	@Operation(summary = "Inserir Chave Pix")
	public ResponseEntity<UUID> inserir(@Valid @RequestBody InserirChavePixRequest chavePixRequest) {

		logger.info("Inserindo a chave " + chavePixRequest);
		var chavePix = chavePixControllerMapper.toChavePix(chavePixRequest);
		var chavePixResponse = chavePixControllerMapper.toChavePixResponse(inserirChavePixInputPort.inserir(chavePix));
		return ResponseEntity.ok().body(chavePixResponse.getId());
	}

	@PutMapping("/alterar/{Id}")
	@Operation(summary = "Alterar Chave Pix")
	public ResponseEntity<ChavePixResponse> alterar(@RequestParam(value = "Id", required = false) UUID id,
			@Valid @RequestBody AlterarChavePixRequest chavePixRequest) {

		logger.info("Alterando a chave " + id);
		var chavePix = chavePixControllerMapper.toChavePix(chavePixRequest);
		var chavePixResponse = chavePixControllerMapper
				.toChavePixResponse(alterarChavePixInputPort.alterar(id, chavePix));
		return ResponseEntity.ok(chavePixResponse);
	}

	@DeleteMapping("/deletar")
	@Operation(summary = "Deletar Chave Pix")
	public ResponseEntity<ChavePixDeleteResponse> deletar(@RequestParam(value = "Id", required = false) UUID id) {

		logger.info("Deletando a chave " + id);
		var chavePixResponse = chavePixControllerMapper.toChavePixDeleteResponse(deleteChavePixInputPort.delete(id));
		return ResponseEntity.ok(chavePixResponse);
	}
}
