package com.projetointegrador.erp.service;

import java.io.Serializable;
import java.time.Instant;

import javax.inject.Inject;

import com.projetointegrador.erp.model.Usuario;
import com.projetointegrador.erp.repository.UsuarioRepository;
import com.projetointegrador.erp.util.Transacional;

public class CadastroUsuarioService implements Serializable{
	
    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioRepository usuarioRepository;

    @Transacional
    public void salvar(Usuario usuario) {
    	usuarioRepository.guardar(usuario);
    }

    @Transacional
    public void excluir(Usuario usuario) {
    	usuarioRepository.remover(usuario);
    }


}
