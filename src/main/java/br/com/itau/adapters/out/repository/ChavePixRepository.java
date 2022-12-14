package br.com.itau.adapters.out.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.adapters.out.repository.entity.ChavePixEntity;

public interface ChavePixRepository extends JpaRepository<ChavePixEntity, UUID>{

	Optional<ChavePixEntity> findByValorChave(String valorChave);

	void deleteByValorChave(String valorChave);
	
	List<ChavePixEntity> findByNumeroAgenciaAndNumeroConta(Integer numeroAgencia, Integer numeroConta);
	
}
