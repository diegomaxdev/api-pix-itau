package br.com.itau.adapters.out;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ChavePixRepository;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.out.BuscarChavePixIdOutPutPort;

@Component
public class BuscarChavePixIdAdapter implements BuscarChavePixIdOutPutPort{
	
	@Autowired
	private ChavePixRepository chavePixRepository;

	@Autowired
	private ChavePixEntityMapper chavePixEntityMapper;
	
	@Override
	public Optional<ChavePix> buscar(UUID id) {

		var chavePixEntity = chavePixRepository.findById(id);
		return chavePixEntity.map(entity -> chavePixEntityMapper.toChavePix(entity));
	}

}
