package br.com.itau.adapters.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ChavePixCustomRepository;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.out.ConsultaChavePixOutPutPort;

@Component
public class ConsultarChavePixAdapter implements ConsultaChavePixOutPutPort{
	
	@Autowired
	private ChavePixCustomRepository chavePixCustomRepository;

	@Autowired
	private ChavePixEntityMapper chavePixEntityMapper;
	
	@Override
	public List<ChavePix> consulta(ChavePix chavePix) {

		var chavePixEntity = chavePixCustomRepository.consulta(chavePix);
		List<ChavePix> listaChaves = new ArrayList<>();
		chavePixEntity.stream().forEach(entity -> listaChaves.add(chavePixEntityMapper.toChavePix(entity)));
		return listaChaves;
	}

}
