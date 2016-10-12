package br.com.alura.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager manager;

	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void listaMovimantacoes() {
		Conta c = new Conta();
		c.setId(1);
		
		//Query query = manager.createQuery("select m from Movimentacao m where m.conta.id = "+c.getId());
		
		//Positional Parameter 
		/*Query query = manager.createQuery("select m from Movimentacao m where m.conta.id = ?1");
		query.setParameter(1, 1);*/
		
		//Named Parameter
		/*Query query = manager.createQuery("select m from Movimentacao m where m.conta.id = :pConta order by m.valor desc");
		query.setParameter("pConta", c.getId());*/
		
		Query query = manager.createQuery("select m from Movimentacao m where m.conta.id = :pConta and m.tipoMovimentacao  = :pTipo");
		query.setParameter("pConta", c.getId());
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		
		List<Movimentacao> movovimentacoes = query.getResultList();
		
		for (Movimentacao mov : movovimentacoes) {
			 System.out.println("\nDescricao ..: " + mov.getDescricao());
	         System.out.println("Valor ......: R$ " + mov.getValor());
		}
		
	}
	
	/**
	 * Teste TypedQuery
	 * 
	 * @param conta
	 * @return
	 */
	public Double mediaDaConta(Conta conta) {

	    TypedQuery<Double> query = 
	            manager.createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta "
	                            + " and m.tipoMovimentacao = 'SAIDA'", Double.class);
	    query.setParameter("pConta", conta);
	    return query.getSingleResult();
	}
	
	/**
	 * Teste NamedQuery
	 * 
	 * @param conta
	 * @return
	 */
	public Long totalDeMovimentacoes(Conta conta) {

	    TypedQuery<Long> query = manager.createNamedQuery("totalDeMovimentacoes", Long.class);
	    query.setParameter("pConta", conta);

	    return query.getSingleResult();
	}
	
	

}
