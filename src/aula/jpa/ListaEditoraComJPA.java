package aula.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaEditoraComJPA {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Cria query
		Query query = manager.createQuery("SELECT e FROM Editora e");

		// Armazena resultados
		List<Editora> lista = query.getResultList();

		// Exibe resultados
		for (Editora e : lista) {
			System.out.println("EDITORA: " + e.getNome() + "\nEMAIL: " + e.getEmail()
					+ "\n----------------------------------------");
		}

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();

	}

}
