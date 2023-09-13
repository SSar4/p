package com.funcionarios.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.funcionarios.model.Funcionario;
import com.funcionarios.services.ServiceFuncionario;
import com.funcionarios.utils.Message;

@Named
@SessionScoped
public class LoginBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean isLogado = false;

	@Inject
	private ServiceFuncionario funcionarioService;

	private Funcionario funcionario;

	@Inject
	private Message message;

	@PostConstruct
	public void init() {
		funcionario = new Funcionario();
	}

	public String login() {

		try {
			funcionario = funcionarioService.login(funcionario);

			if (funcionario.getId() != null) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("funcionario",
						funcionario.getId());
				this.message.addMessage("Bem vindo " + funcionario.getNome() + "!");
				this.funcionario = new Funcionario();
				System.out.println("is logado " + isLogado);
				this.isLogado = true;
				System.out.println("is logado iii " + isLogado);
				return "home?faces-redirect=true";
			}
		} catch (Exception e) {
			this.message.addMessage("Email ou Senha incorretos");
			return "index?faces-redirect=true";
		}

		this.message.addMessage("Email ou Senha incorretos");
		return "index?faces-redirect=true";
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		if (session != null) {
			// Remover os atributos de sessão específicos que você deseja limpar
			session.removeAttribute("funcionario"); // Substitua "usuarioLogado" pelo nome do atributo

			session.invalidate();
		}
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		// Redirecionar para a página de login (você pode ajustar o URL conforme
		// necessário)
		return "/index.xhtml?faces-redirect=true";
	}

	public boolean isLogado() {
		return isLogado;
	}

	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}

	public ServiceFuncionario getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(ServiceFuncionario funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}