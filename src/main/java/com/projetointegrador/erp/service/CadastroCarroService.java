package com.projetointegrador.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.projetointegrador.erp.model.Carro;
import com.projetointegrador.erp.repository.CarroRepository;
import com.projetointegrador.erp.util.Transacional;

public class CadastroCarroService implements Serializable{
	
    private static final long serialVersionUID = 1L;

    @Inject
    private CarroRepository carroRepository;

    @Transacional
    public void salvar(Carro carro) {
    	carroRepository.guardar(carro);
    }

    @Transacional
    public void excluir(Carro carro) {
    	carroRepository.remover(carro);
    }


}
