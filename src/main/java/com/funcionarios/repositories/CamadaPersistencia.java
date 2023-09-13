package com.funcionarios.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CamadaPersistencia {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencePostgres");

        EntityManager em = emf.createEntityManager();

        

        // Declarando os repositórios
        RepositoryFuncionario rf = new RepositoryFuncionario(em);
        
         rf.listar();
        
        //rf.inserir(f);

        em.getTransaction().commit(); // Confirme a transação aqui

     
        
        
    }
}