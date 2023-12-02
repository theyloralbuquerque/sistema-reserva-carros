package com.projetointegrador.erp.controller;

import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.projetointegrador.erp.model.Carro;
import com.projetointegrador.erp.model.MarcaCarro;
import com.projetointegrador.erp.model.Usuario;
import com.projetointegrador.erp.repository.CarroRepository;
import com.projetointegrador.erp.repository.UsuarioRepository;
import com.projetointegrador.erp.service.CadastroCarroService;
import com.projetointegrador.erp.service.CadastroUsuarioService;
import com.projetointegrador.erp.util.FacesMessages;

@Named
@ViewScoped
public class ReservaCarrosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCarroService cadastroCarroService;
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Inject
	private CarroRepository carroRepository;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private FacesMessages messages;
	
	private List<Carro> listaCarros;
	
	private List<Usuario> listaUsuarios;
	
	private String termoPesquisa;
	
	private Carro carro;
	
	private Usuario usuario;
	
	public void prepararNovoCarro() {
		carro = new Carro();
	}
	
	public void prepararNovoUsuario() {
		usuario = new Usuario();
	}
	
	public void prepararEdicao() {
		carro = carroRepository.porId(carro.getIdCarro());
	}
	
	public void prepararEdicaoUsuario() {
		usuario = usuarioRepository.porId(usuario.getIdUsuario());
	}
	
	public void salvar() {
		cadastroCarroService.salvar(carro);
		
		atualizarRegistros();
		
		messages.info("Carro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(Arrays.asList(
				"frm:carrosDatatable", "frm:messages"));
		
		//PrimeFaces.current().ajax().update("frm:carrosDataTable", "frm:messages");
	}
	
	public void salvarUsuario() {
		usuario.setDataCadastro(Instant.now());
		cadastroUsuarioService.salvar(usuario);
		
		atualizarRegistrosUsuario();
		
		messages.info("Usuário salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(Arrays.asList(
				"frmUser:usuariosDatatable", "frmUser:messages"));
		
		//PrimeFaces.current().ajax().update("frm:carrosDataTable", "frm:messages");
	}
	
	public void excluir() {
		cadastroCarroService.excluir(carro);
		
		carro = null;
		
		atualizarRegistros();
		
		messages.info("Carro excluído com sucesso!");
	}
	
	public void excluirUsuario() {
		cadastroUsuarioService.excluir(usuario);
		
		usuario = null;
		
		atualizarRegistrosUsuario();
		
		messages.info("Usuario excluído com sucesso!");
	}
	
	public void pesquisar() {
		listaCarros = carroRepository.pesquisar(termoPesquisa);
		
		if (listaCarros.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
	
	public void pesquisarUsuario() {
		listaUsuarios = usuarioRepository.pesquisar(termoPesquisa);
		
		if (listaUsuarios.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
	
	public void todosCarros() {
		listaCarros = carroRepository.todos();
	}
	
	public void todosUsuarios() {
		listaUsuarios = usuarioRepository.todos();
	}
	
	private void atualizarRegistros() {
		if (jaHouvePesquisa()) { 
			pesquisar(); // Se já tiver acontecido a pesquisa desse termo, chama o método pesquisar(). 
		} else {
			todosCarros();
		}
	}
	
	private void atualizarRegistrosUsuario() {
		if (jaHouvePesquisa()) { 
			pesquisarUsuario(); // Se já tiver acontecido a pesquisa desse termo, chama o método pesquisar(). 
		} else {
			todosUsuarios();
		}
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
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isUsuarioSelecionado() {
		return usuario != null && usuario.getIdUsuario() != null;
	}

	public String usuario() {
		return "Usuario?faces-redirect=true";
	}
}
