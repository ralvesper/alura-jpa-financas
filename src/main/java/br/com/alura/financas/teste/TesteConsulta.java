package br.com.alura.financas.teste;


import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.alura.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsulta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getInstance().getEntityManager();
		
		MovimentacaoDAO dao = new MovimentacaoDAO(manager);
		dao.listaMovimantacoes();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		Double mediaDaConta = dao.mediaDaConta(conta);
		
		System.out.println("Média de gastos: "+mediaDaConta);
		
		Long totalDeMovimentacoes = dao.totalDeMovimentacoes(conta);
		
		System.out.println("Total de Movimentações: "+totalDeMovimentacoes);
		
	}
}
