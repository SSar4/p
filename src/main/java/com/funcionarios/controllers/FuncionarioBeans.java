package com.funcionarios.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.funcionarios.model.Funcionario;
import com.funcionarios.model.IdFuncionario;
import com.funcionarios.services.ServiceFuncionario;

@Named
@SessionScoped
public class FuncionarioBeans  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServiceFuncionario funcionarioService;

	
	private Funcionario funcionario;
	private IdFuncionario idFuncionario;
	private int cargoSelecionado;
	
	@PostConstruct
	public void init() {
		funcionario = new Funcionario();
		idFuncionario = new IdFuncionario();
	}
	public String inserir() {
		if(funcionario.getId() == null) {
			IdFuncionario id = new IdFuncionario();
			id.setCpf(idFuncionario.getCpf());
			funcionario.setId(id);
			funcionarioService.salvar(funcionario, cargoSelecionado);
			funcionario = new Funcionario();
			idFuncionario = new IdFuncionario();
			cargoSelecionado = 0;
		}else {
			funcionarioService.salvar(funcionario, cargoSelecionado);
			funcionario = new Funcionario();
			idFuncionario = new IdFuncionario();
			cargoSelecionado = 0;
		}
		
		return "home.xhtml?faces-redirect=true";
	}
	
	public String excluir(Funcionario f) {
	    funcionarioService.remover(f);
		return null;//"cadastra_funcionario.xhtml?faces-redirect=true";
	}
	
	public String formularioEditar(Funcionario f) {
		funcionario = f;
		cargoSelecionado = Integer.parseInt(String.valueOf(f.getCargo().getId()));
		return "editar_funcionario.xhtml?faces-redirect=true";
	}
	
	public String formularioCadastro() {
		funcionario = new Funcionario();
		return "cadastra_funcionario.xhtml?faces-redirect=true";
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarioService.listar();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public int getCargoSelecionado() {
		return cargoSelecionado;
	}
	public void setCargoSelecionado(int cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}
	public IdFuncionario getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(IdFuncionario idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}
