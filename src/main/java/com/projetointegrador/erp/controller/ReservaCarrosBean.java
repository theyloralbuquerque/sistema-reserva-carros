package com.projetointegrador.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.projetointegrador.erp.model.Carro;
import com.projetointegrador.erp.model.MarcaCarro;
import com.projetointegrador.erp.repository.CarroRepository;
import com.projetointegrador.erp.service.CadastroCarroService;
import com.projetointegrador.erp.util.FacesMessages;

@Named
@ViewScoped
public class ReservaCarrosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCarroService cadastroCarroService;
	
	@Inject
	private CarroRepository carroRepository;
	
	@Inject
	private FacesMessages messages;
	
	private List<Carro> listaCarros;
	
	private String termoPesquisa;
	
	private Carro carro;
	
	public void prepararNovoCarro() {
		carro = new Carro();
	}
	
	public void prepararEdicao() {
		carro = carroRepository.porId(carro.getIdCarro());
	}
	
	public void salvar() {
		cadastroCarroService.salvar(carro);
		
		if (jaHouvePesquisa()) {
			pesquisar();
		}
		
		messages.info("Empresa salva com sucesso!");
		
		//PrimeFaces.current().ajax().update("frm:carrosDataTable", "frm:messages");
	}
	
	public void pesquisar() {
		listaCarros = carroRepository.pesquisar(termoPesquisa);
		
		if (listaCarros.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
	
	public void todosCarros() {
		listaCarros = carroRepository.todos();
	}
	
	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}
	
	public List<Carro> getListaCarros() {
		return listaCarros;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public MarcaCarro[] getMarcasCarro() {
		return MarcaCarro.values();
	}
	
	public Carro getCarro() {
		return carro;
	}
	
	public void setCarro(Carro carro) {
		this.carro = carro;
		
	}
	
	public boolean isCarroSelecionado() {
		return carro != null && carro.getIdCarro() != null;
	}
}
