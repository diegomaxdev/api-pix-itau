package br.com.itau.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.adapters.out.repository.entity.ContaEntity;

public interface ContaRepository extends JpaRepository<ContaEntity, Long>{

	ContaEntity findByNumeroAgenciaAndNumeroConta(Integer numeroAgencia, Integer numeroConta);
	
	
}
