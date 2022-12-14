package br.com.itau.adapters.out.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.itau.adapters.out.repository.entity.ChavePixEntity;
import br.com.itau.application.core.domain.ChavePix;

@Repository
public class ChavePixCustomRepository {

	private final EntityManager em;

	public ChavePixCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<ChavePixEntity> consulta(ChavePix chavePix){
		
		String query = "SELECT C from ChavePixEntity as C ";
		String condicao = "WHERE";
		
		if(chavePix.getId() != null) {
			query += condicao + " C.id = :id";
			condicao = " AND ";
		}
		
		if(chavePix.getTipoChave() != null) {
			query += condicao + " C.tipoChave = :tipoChave";
			condicao = " AND ";
		}
		
		if(chavePix.getNumeroAgencia() != null) {
			query += condicao + " C.numeroAgencia = :numeroAgencia";
			condicao = " AND ";
		}
		
		if(chavePix.getNumeroConta() != null) {
			query += condicao + " C.numeroConta = :numeroConta";
			condicao = " AND ";
		}
		
		if(chavePix.getNomeCorrentista() != null) {
			query += condicao + " C.nomeCorrentista = :nomeCorrentista";
			condicao = " AND ";
		}
		
		if(chavePix.getDataInclusao() != null) {
			query += condicao + " C.dataInclusao = :dataInclusao";
			condicao = " AND ";
		}
		
		if(chavePix.getDataAlteracao() != null) {
			query += condicao + " C.dataAlteracao = :dataAlteracao";
			condicao = " AND ";
		}
		
		var qr = em.createQuery(query, ChavePixEntity.class);
		
		if(chavePix.getId() != null) {
			qr.setParameter("id", chavePix.getId());
		}
		
		if(chavePix.getTipoChave() != null) {
			qr.setParameter("tipoChave", chavePix.getTipoChave());
		}
		
		if(chavePix.getNumeroAgencia() != null) {
			qr.setParameter("numeroAgencia", chavePix.getNumeroAgencia());
		}
		
		if(chavePix.getNumeroConta() != null) {
			qr.setParameter("numeroConta", chavePix.getNumeroConta());
		}
		
		if(chavePix.getNomeCorrentista() != null) {
			qr.setParameter("nomeCorrentista", chavePix.getNomeCorrentista());
		}
		
		if(chavePix.getDataInclusao() != null) {
			qr.setParameter("dataInclusao", chavePix.getDataInclusao());
		}
		
		if(chavePix.getDataAlteracao() != null) {
			qr.setParameter("dataAlteracao", chavePix.getDataAlteracao());
		}
		
		return qr.getResultList();
	}
}
