package br.com.caelum.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@SessionScoped
public class ArgentumBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Negociacao> negociacoes;
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}

	public void preparaDados() {
		ClienteWebService cliente = new ClienteWebService();
		negociacoes = cliente.getNegociacoes();
	}
}
