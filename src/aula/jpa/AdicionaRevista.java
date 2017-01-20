package aula.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaRevista {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Abre transacao
		manager.getTransaction().begin();

		for (int i = 0; i < 15; i++) {
			Revista revista = new Revista();
			revista.setNome("Revista " + (i + 1));
			revista.setPreco(10.0 * (i + 1));
			manager.persist(revista);
		}

		// Comita transacao
		manager.getTransaction().commit();

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();
	}

}
