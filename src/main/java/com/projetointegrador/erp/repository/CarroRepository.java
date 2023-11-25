package com.projetointegrador.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projetointegrador.erp.model.Carro;

public class CarroRepository implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public CarroRepository() { // Construtor padrão.
	}

	public CarroRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public Carro porId(Long idCarro) {
		return manager.find(Carro.class, idCarro);
	}
	
	public List<Carro> pesquisar(String modelo) {
		TypedQuery<Carro> query = manager.createQuery("from Carro where modelo like :modelo", Carro.class);
		query.setParameter("modelo", modelo + "%");
		return query.getResultList();
	}
	
	public List<Carro> todos() {
		return manager.createQuery("from Carro", Carro.class).getResultList();
	}

	public Carro guardar(Carro carro) {
		return manager.merge(carro);
	}
	
	public void remover(Carro carro) {
		carro = porId(carro.getIdCarro());
		manager.remove(carro);
	}
}
