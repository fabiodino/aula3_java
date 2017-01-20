package aula.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Consultas {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Recuperando a quantidade de revistas
		String jpql = "SELECT COUNT(x) FROM Revista x";
		TypedQuery<Long> consulta1 = manager.createQuery(jpql, Long.class);
		Long contador = consulta1.getSingleResult();
		System.out.println("Há " + contador + " revistas.\n");

		// Recuperando a quantidade de revistas com preço acima de 100
		jpql = "SELECT COUNT(x) FROM Revista x WHERE x.preco > 100";
		TypedQuery<Long> consulta2 = manager.createQuery(jpql, Long.class);
		contador = consulta2.getSingleResult();
		System.out.println("Há " + contador + " revistas com preço acima de 100.\n");

		// Somando o preco das revistas
		jpql = "SELECT SUM(x.preco) FROM Revista x";
		TypedQuery<Double> consulta3 = manager.createQuery(jpql, Double.class);
		Double soma = consulta3.getSingleResult();
		System.out.println("A soma do preço das revistas é " + soma + "\n");

		// Recuperando o preco da revista mais cara
		jpql = "SELECT MAX(x.preco) FROM Revista x";
		TypedQuery<Double> consulta4 = manager.createQuery(jpql, Double.class);
		Double precoMaximo = consulta4.getSingleResult();
		System.out.println("o preço da revista mais cara é " + precoMaximo + "\n");

		// Recuperando a média dos precos das revistas
		jpql = "SELECT AVG(x.preco) FROM Revista x";
		TypedQuery<Double> consulta5 = manager.createQuery(jpql, Double.class);
		Double media = consulta5.getSingleResult();
		System.out.println("A média dos preços das revistas é " + media + "\n");

		// Recuperando todas as revistas
		jpql = "SELECT x FROM Revista x";
		TypedQuery<Revista> consulta6 = manager.createQuery(jpql, Revista.class);
		List<Revista> revistas = consulta6.getResultList();
		System.out.println("Todas as revistas: ");

		for (Revista revista : revistas) {
			System.out.println("Id: " + revista.getId());
			System.out.println("Nome: " + revista.getNome());
			System.out.println("Preço: " + revista.getPreco());
			System.out.println();
		}

		// Recuperando as revistas com preço acima de 100
		jpql = "SELECT x FROM Revista x WHERE x.preco > 100";
		TypedQuery<Revista> consulta7 = manager.createQuery(jpql, Revista.class);
		revistas = consulta7.getResultList();
		System.out.println("Revistas com preço acima de 100: ");

		for (Revista revista : revistas) {
			System.out.println("Id: " + revista.getId());
			System.out.println("Nome: " + revista.getNome());
			System.out.println("Preço: " + revista.getPreco());
			System.out.println();
		}

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();

	}

}
