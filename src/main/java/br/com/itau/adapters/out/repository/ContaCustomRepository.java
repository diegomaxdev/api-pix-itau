package br.com.itau.adapters.out.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.itau.adapters.out.repository.entity.ContaEntity;
import br.com.itau.application.core.domain.Conta;

@Repository
public class ContaCustomRepository {

	private final EntityManager em;

	public ContaCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<ContaEntity> consulta(Conta conta){
		
		String query = "SELECT C from ContaEntity as C ";
		String condicao = "WHERE";
						
		if(conta.getNumeroAgencia() != null) {
			query += condicao + " C.numeroAgencia = :numeroAgencia";
			condicao = " AND ";
		}
		
		if(conta.getNumeroConta() != null) {
			query += condicao + " C.numeroConta = :numeroConta";
			condicao = " AND ";
		}
		
		if(conta.getNomeCorrentista() != null) {
			query += condicao + " C.nomeCorrentista = :nomeCorrentista";
			condicao = " AND ";
		}
		
		if(conta.getSobrenomeCorrentista() != null) {
			query += condicao + " C.sobrenomeCorrentista = :nomeCorrentista";
		}
					
		var qr = em.createQuery(query, ContaEntity.class);
		
		if(conta.getNumeroAgencia() != null) {
			qr.setParameter("numeroAgencia", conta.getNumeroAgencia());
		}
		
		if(conta.getNumeroConta() != null) {
			qr.setParameter("numeroConta", conta.getNumeroConta());
		}
		
		if(conta.getNomeCorrentista() != null) {
			qr.setParameter("nomeCorrentista", conta.getNomeCorrentista());
		}
		
		if(conta.getSobrenomeCorrentista() != null) {
			qr.setParameter("sobrenomeCorrentista", conta.getSobrenomeCorrentista());
		}
		
		return qr.getResultList();
	}
}
