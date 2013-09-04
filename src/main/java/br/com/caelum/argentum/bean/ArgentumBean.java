package br.com.caelum.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@SessionScoped
public class ArgentumBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Negociacao> negociacoes;

	@PostConstruct
	public void preparaDados() {
		ClienteWebService cliente = new ClienteWebService();
		negociacoes = cliente.getNegociacoes();
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
}
