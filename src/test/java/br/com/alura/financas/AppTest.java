package br.com.alura.financas;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		
		/*Conta conta = new Conta();
		conta.setTitular("Rodrigo Alves Pereira");
		conta.setBanco("Itaú");
		conta.setAgencia("2978");
		conta.setSaldo(new BigDecimal(653.82));
		conta.setNumero("20233-7");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas-mysql");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();*/
		
		assertTrue(true);
	}
}
