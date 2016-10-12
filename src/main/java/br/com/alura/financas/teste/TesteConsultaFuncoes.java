package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoes {
	public static void main(String[] args) {
		/*testaSoma();
		testaMedia();
		testaNamedQueryMedia();*/
		testaFuncaoMax();
	}

	private static void testaSoma() {
		EntityManager manager = JPAUtil.getInstance().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		Query query = manager
				.createQuery("select m from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao  = :pTipo");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Movimentacao> movovimentacoes = query.getResultList();

		for (Movimentacao mov : movovimentacoes) {
			System.out.println("\nDescricao ..: " + mov.getDescricao());
			System.out.println("Valor ......: R$ " + mov.getValor());
		}

		TypedQuery<BigDecimal> query2 = manager.createQuery(
				"select sum(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao  = :pTipo",
				BigDecimal.class);
		query2.setParameter("pConta", conta);
		query2.setParameter("pTipo", TipoMovimentacao.SAIDA);

		BigDecimal total = query2.getSingleResult();
		System.out.println("Total ......: R$ " + total.setScale(2, RoundingMode.HALF_EVEN));
	}

	private static void testaMedia() {

		EntityManager manager = JPAUtil.getInstance().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		TypedQuery<Double> query = manager.createQuery(
				"select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao  = :pTipo",
				Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		Double media = query.getSingleResult();

		System.out.println("Média ......: R$ " + media);
	}
	
	private static void testaNamedQueryMedia() {

		EntityManager manager = JPAUtil.getInstance().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		TypedQuery<Double> query = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao",Double.class);
				
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		Double media = query.getSingleResult();

		System.out.println("Média ......: R$ " + media);
	}
	
	private static void testaFuncaoMax() {

		EntityManager manager = JPAUtil.getInstance().getEntityManager();

		Conta conta = manager.find(Conta.class, 1);
		
		TypedQuery<BigDecimal> query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);			
		query.setParameter("pConta", conta);
	
		BigDecimal valor = query.getSingleResult();

		System.out.println("Movimentação Máxima......: R$ " + valor);
	}
	
	

}
