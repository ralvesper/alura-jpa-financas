package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		
        EntityManager manager = JPAUtil.getInstance().getEntityManager();
        
        
        /*Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
		  System.out.println("Titular da conta: " + movimentacao.getConta().getTitular()); */
        
       
        /*Conta conta = manager.find(Conta.class, 44); //id deve existir
        //manager.close(); //fechando EntityManager gera erro ao carregar as movimentações por ser lazy (default)
        System.out.println(conta.getMovimentacoes().size());*/
        

        Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = 1");
        List<Conta> contas = query.getResultList();
        
        manager.close(); //usando o join fetch posso fechar o EntityManager antes de acessar as movimentações
        
        for (Conta conta : contas) {
        	System.out.println("Numero da Conta............: " + conta.getNumero());
            System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
        }
    }
}
