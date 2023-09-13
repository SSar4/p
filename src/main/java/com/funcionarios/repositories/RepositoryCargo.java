package com.funcionarios.repositories;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.funcionarios.model.Cargo;


public class RepositoryCargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public RepositoryCargo() {

	}

	public RepositoryCargo(EntityManager manager) {
		this.manager = manager;
	}
	
	public Cargo porId(Long id) {
		return manager.find(Cargo.class, id);
	}

}
