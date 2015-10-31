package br.com.mribeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mribeiro.model.Pessoa;

public class Pessoas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager manager;
	
	@Inject
	public Pessoas(EntityManager manager) {
		this.manager = manager;
	}
	
	
	/**
	 * Consulta a pessoa pelo id
	 * @param id
	 * @return
	 */
	public Pessoa getId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	
	/**
	 * Consulta todas as pessoas 
	 * @return
	 */
	public List<Pessoa> getAll() {
		
		TypedQuery<Pessoa> query = manager.createQuery("FROM Pessoa", Pessoa.class);
		
		return query.getResultList();
	}
}
