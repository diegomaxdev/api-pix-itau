package br.com.itau.adapters.out.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.itau.adapters.out.integration.response.ContaResponseIntegration;

@FeignClient(value="ContaComplementoClient",  url="${api.conta}" )
public interface ContaComplementoClient {

	@GetMapping("/agencia/{agencia}/conta/{conta}")
	ContaResponseIntegration getConta(@PathVariable("agencia") Integer agencia, @PathVariable("conta") Integer conta);
}
