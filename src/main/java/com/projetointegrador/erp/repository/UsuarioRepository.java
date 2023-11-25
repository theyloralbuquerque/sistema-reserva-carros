package com.projetointegrador.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.projetointegrador.erp.model.Usuario;

public class UsuarioRepository implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public UsuarioRepository() { // Construtor padrão.
	}

	public UsuarioRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public Usuario porId(Long idUsuario) {
		return manager.find(Usuario.class, idUsuario);
	}
	
	public List<Usuario> pesquisar(String nome) {
		TypedQuery<Usuario> query = manager.createQuery("from Usuario where nome like :nome", Usuario.class);
		query.setParameter("nome", nome + "%");
		return query.getResultList();
	}

	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	public void remover(Usuario usuario) {
		usuario = porId(usuario.getIdUsuario());
		manager.remove(usuario);
	}
}
