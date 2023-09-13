package com.funcionarios.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.funcionarios.model.Funcionario;
import com.funcionarios.model.IdFuncionario;

public class RepositoryFuncionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public RepositoryFuncionario() {

	}

	public RepositoryFuncionario(EntityManager manager) {
		this.manager = manager;
	}

	public Funcionario inserir(Funcionario f) {
		return manager.merge(f);
	}

	public Funcionario login(Funcionario f) {
		TypedQuery<Funcionario> query = manager.createQuery("from Funcionario where email = :email and senha = :senha",
				Funcionario.class);
		query.setParameter("email", f.getEmail());
		query.setParameter("senha", f.getSenha());
		query.setMaxResults(1);
		return query.getSingleResult();
	}
	
	public List<Funcionario> listar() {
		TypedQuery<Funcionario> query = manager.createQuery(
				"from Funcionario f", Funcionario.class);
		List<Funcionario> f = query.getResultList();
		return f;
	}
	
	public void remover(Funcionario f) {
		IdFuncionario id = new IdFuncionario();
		id.setCpf(f.getId().getCpf());
		id.setMatricula(f.getId().getMatricula());
		Funcionario aux =manager.find(Funcionario.class, id);
		manager.remove(aux);
	}
}
