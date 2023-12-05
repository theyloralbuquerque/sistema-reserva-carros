package com.projetointegrador.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projetointegrador.erp.model.Carro;
import com.projetointegrador.erp.model.CarroInteresse;

public class CarroInteresseRepository extends Carro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public CarroInteresseRepository() { // Construtor padrão.
	}

	public CarroInteresseRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public CarroInteresse porId(Long idInteressado) {
		return manager.find(CarroInteresse.class, idInteressado);
	}
	
	public List<CarroInteresse> pesquisar(String modelo) {
		TypedQuery<CarroInteresse> query = manager.createQuery("from CarroInteresse where modelo like :modelo", CarroInteresse.class);
		query.setParameter("modelo", modelo + "%");
		return query.getResultList();
	}
	
	public List<CarroInteresse> todos() {
		return manager.createQuery("SELECT ci FROM CarroInteresse ci", CarroInteresse.class).getResultList();
	}

	public CarroInteresse guardar(CarroInteresse carroInteresse) {
		return manager.merge(carroInteresse);
	}
	
	public void remover(CarroInteresse carroInteresse) {
		carroInteresse = porId(carroInteresse.getIdInteressado());
		manager.remove(carroInteresse);
	}
}
