package br.com.caelum.financas.util;


import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta; 
 
public class TesteEstadosJPA { 
 
  private static EntityManager manager;

public static void main(String[] args) {
 
		manager = JPAUtil.getInstance().getEntityManager();
 
		manager.getTransaction().begin();

        // ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 38);

        // commit antes da alteração
        manager.getTransaction().commit();

        // Alteração do titular da conta
        conta.setTitular("Caelum ensino e inovação");
        
        manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();

        manager.close();
 
	} 
} 