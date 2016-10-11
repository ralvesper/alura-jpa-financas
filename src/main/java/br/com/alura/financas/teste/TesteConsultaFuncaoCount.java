package br.com.alura.financas.teste;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getInstance().getEntityManager();
		
		Conta c = manager.find(Conta.class,1);
		
		Query query = manager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		
		query.setParameter("pConta", c);
		
		Long quantidade = (Long) query.getSingleResult();
		System.out.println("Total de movimentações: " + quantidade);
		
	}
}
