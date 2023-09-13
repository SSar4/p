package com.funcionarios.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class IdFuncionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String matricula;
	private String cpf;

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdFuncionario other = (IdFuncionario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(matricula, other.matricula);
	}
	@Override
	public String toString() {
		return "IdFuncionario [matricula=" + matricula + ", cpf=" + cpf + "]";
	}
	
	
}
