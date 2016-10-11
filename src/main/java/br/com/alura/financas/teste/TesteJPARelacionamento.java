package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	
	public static void main(String[] args) {
		Conta conta1 = new Conta();
		conta1.setBanco("001 - BANCO DO BRASIL");
		conta1.setNumero("1743-7");
		conta1.setAgencia("2158");
		conta1.setTitular("Lucio Silva");
		
		Movimentacao mov = new Movimentacao();
		mov.setConta(conta1);
		mov.setData(Calendar.getInstance());
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov.setValor(new BigDecimal("123.30"));
		
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta1);
		em.persist(mov);
		
		em.getTransaction().commit();
		em.close();
	}

}
