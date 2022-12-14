package br.com.itau.adapters.in.controller.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.itau.adapters.in.controller.ChavePixController;
import br.com.itau.application.exception.ApplicationException;
import br.com.itau.application.exception.ApplicationNotFoundException;
import feign.codec.DecodeException;

@ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(ChavePixController.class);
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException ex, WebRequest request){
		
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + ex.getTipoExcecao().getMensagemErro());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getTipoExcecao().getMensagemErro()))
				.erro(ex.getTipoExcecao().toString().toLowerCase())
				.codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleApplicationNotFoundException(ApplicationNotFoundException ex, WebRequest request){
		
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + ex.getTipoExcecao().getMensagemErro());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getTipoExcecao().getMensagemErro()))
				.erro(ex.getTipoExcecao().toString().toLowerCase())
				.codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	
	// Criado para tratar os tipos de exceçao EmptyResultDataAccess exemplo quando deleta no BD o registro que nao existe
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
	
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + ex.getMessage());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getMessage()))
				.erro(ex.getCause().toString().toLowerCase())
				.codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
				
		return new ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
	}
		
	
	@ExceptionHandler({MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
	
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + ex.getMessage());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getMessage()))
				.erro(ex.getCause().toString().toLowerCase())
				.codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
				
		return new ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
	}
		
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request){
				
		logger.warn("ERRO : "+ HttpStatus.BAD_REQUEST.value() + " - " + ex.getMessage());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getMessage()))
				.erro(ex.getCause().toString().toLowerCase())
				.codigo(HttpStatus.BAD_REQUEST.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
				
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}		
			
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ErrorResponse> handleInvalidFormatException(InvalidFormatException ex, WebRequest request){
		
		
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + ex.getMessage());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getMessage()))
				.erro(ex.getCause().toString().toLowerCase())
				.codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
	}
		
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request){
		
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + ex.getMessage());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getMessage()))
				.erro(ex.getCause().toString().toLowerCase())
				.codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex, WebRequest request){
		
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + ex.getMessage());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getMessage()))
				.erro(ex.getCause().toString().toLowerCase())
				.codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
	}
		
	@ExceptionHandler(DecodeException.class)
	public ResponseEntity<ErrorResponse> decodeException(DecodeException ex, WebRequest request){
		
		logger.warn("ERRO : "+ HttpStatus.BAD_REQUEST.value() + " - " + ex.getMessage());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList(ex.getMessage()))
				.erro(ex.getLocalizedMessage())
				.codigo(HttpStatus.BAD_REQUEST.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		var erros = ex.getFieldErrors().stream()
				.map(item -> item.getField() + " " + item.getDefaultMessage())
				.collect(Collectors.toList());
		
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + erros.toString());
		
		var response = ErrorResponse.builder()
				.messagens(erros)
				.erro("Erro de Arqumentos inválidos")
				.codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	//PARAMETROS DE ENUMS E ATRIBUTOS QUE FALHAM AO CONVERTER
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		logger.warn("ERRO : "+ HttpStatus.UNPROCESSABLE_ENTITY.value() + " - " + ex.getCause() != null ? ex.getCause().toString() : ex.toString());
		
		var response = ErrorResponse.builder()
				.messagens(Arrays.asList("Falha na conversão de um valor"))
				.erro(ex.getCause() != null ? ex.getCause().toString() : ex.toString())
				.codigo(HttpStatus.BAD_REQUEST.value())
				.timestemp(new Date())
				.path(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
