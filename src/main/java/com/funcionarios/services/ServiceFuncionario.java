package com.funcionarios.services;

import java.io.Serializable;
import java.time.Year;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import com.funcionarios.model.Cargo;
import com.funcionarios.model.Funcionario;
import com.funcionarios.repositories.RepositoryCargo;
import com.funcionarios.repositories.RepositoryFuncionario;
import com.funcionarios.utils.Transacional;

public class ServiceFuncionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RepositoryFuncionario repository;
	
	@Inject
	private RepositoryCargo repositoryCargo;

	@Transacional
	public void salvar(Funcionario f, int c) {
		if(f.getId().getMatricula() == null) {
			int n1 = gerarNumeroAleatorio();
	        int n2 = gerarNumeroAleatorio();
	        int n3 = gerarNumeroAleatorio();
		
			f.getId().setMatricula(Year.now()+"-"+n1+n2+n3);
		}
		Cargo cargo = repositoryCargo.porId((long) c);
		f.setCargo(cargo);
		repository.inserir(f);
	}
	
	public Funcionario login(Funcionario p) {
		return repository.login(p);
	}
	
	public List<Funcionario> listar(){
		return repository.listar();
	}
	
	@Transacional
	public void remover(Funcionario f) {
		repository.remover(f);
	}
	
	private static int gerarNumeroAleatorio() {
        return new  Random().nextInt(9) + 1; // Gera um número entre 1 e 100
    }
}
