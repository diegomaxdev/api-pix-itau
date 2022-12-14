package br.com.itau;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiChavePixApplication {

	private static Logger logger = LoggerFactory.getLogger(ApiChavePixApplication.class);
	
	public static void main(String[] args) {
		
		logger.info("Iniciando API de Cadastro de Chaves");
		SpringApplication.run(ApiChavePixApplication.class, args);
		logger.info("API de Cadastro de Chaves - Pronta para o uso");
	}

}
