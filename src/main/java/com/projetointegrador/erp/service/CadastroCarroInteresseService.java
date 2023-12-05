package com.projetointegrador.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.projetointegrador.erp.model.CarroInteresse;
import com.projetointegrador.erp.repository.CarroInteresseRepository;
import com.projetointegrador.erp.util.Transacional;

public class CadastroCarroInteresseService implements Serializable{
	
    private static final long serialVersionUID = 1L;

    @Inject
    private CarroInteresseRepository carroInteresseRepository;

    @Transacional
    public void salvar(CarroInteresse carroInteresse) {
    	carroInteresseRepository.guardar(carroInteresse);
    }

    @Transacional
    public void excluir(CarroInteresse carroInteresse) {
    	carroInteresseRepository.remover(carroInteresse);
    }


}
