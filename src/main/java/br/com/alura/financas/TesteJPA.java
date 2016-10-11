package br.com.alura.financas;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
	
			Conta conta = new Conta();
			conta.setTitular("Nico Steppat");
			conta.setBanco("Banco Santos");
			conta.setAgencia("123");
			conta.setNumero("4567-8");
			

			//double inicio = System.currentTimeMillis();

			EntityManager manager = JPAUtil.getInstance().getEntityManager();

			manager.getTransaction().begin();
			
			//Conta conta = manager.find(Conta.class, 41);
			
			manager.merge(conta);
			
			System.out.println(conta.getId());

			manager.getTransaction().commit();

			manager.close();

			//double fim = System.currentTimeMillis();
			//System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");
		
	}
}
