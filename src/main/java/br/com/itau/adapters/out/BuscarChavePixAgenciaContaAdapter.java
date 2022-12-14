package br.com.itau.adapters.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itau.adapters.out.repository.ChavePixRepository;
import br.com.itau.adapters.out.repository.mapper.ChavePixEntityMapper;
import br.com.itau.application.core.domain.ChavePix;
import br.com.itau.application.ports.out.BuscarChavePixAgenciaContaOutPutPort;

@Component
public class BuscarChavePixAgenciaContaAdapter implements BuscarChavePixAgenciaContaOutPutPort {

	@Autowired
	private ChavePixRepository chavePixRepository;

	@Autowired
	private ChavePixEntityMapper chavePixEntityMapper;

	@Override
	public List<ChavePix> buscar(Integer numeroAgencia, Integer numeroConta) {

		var chavePixEntity = chavePixRepository.findByNumeroAgenciaAndNumeroConta(numeroAgencia, numeroConta);

		List<ChavePix> listaChaves = new ArrayList<>();
		chavePixEntity.stream().forEach(entity -> listaChaves.add(chavePixEntityMapper.toChavePix(entity)));
		return listaChaves;
	}

}
