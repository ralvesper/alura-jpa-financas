package br.com.alura.financas.teste;


import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsulta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getInstance().getEntityManager();
		
		MovimentacaoDAO dao = new MovimentacaoDAO(manager);
		dao.listaMovimantacoes();
		
	}
}
