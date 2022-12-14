package br.com.itau.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ChavePixRepository;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.out.BuscarChavePixOutPutPort;

@Component
public class BuscarChavePixAdapter implements BuscarChavePixOutPutPort{
	
	@Autowired
	private ChavePixRepository chavePixRepository;

	@Autowired
	private ChavePixEntityMapper chavePixEntityMapper;
	
	@Override
	public Optional<ChavePix> buscar(String valorChave) {

		var chavePixEntity = chavePixRepository.findByValorChave(valorChave);
		return chavePixEntity.map(entity -> chavePixEntityMapper.toChavePix(entity));
	}

}
