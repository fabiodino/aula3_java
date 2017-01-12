package aula.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaLivroAutor {
	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Abre transacao
		manager.getTransaction().begin();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria objeto 1
		Autor a = new Autor();

		// Cria user input
		System.out.println("Digite o nome do autor: ");
		a.setNome(entrada.nextLine());

		// Cria objeto 2
		Livro l = new Livro();

		// Cria user input
		System.out.println("Digite o nome do livro: ");
		l.setNome(entrada.nextLine());

		// Adiciona objeto 1
		l.getAutores().add(a);

		// Fecha entrada
		entrada.close();

		// Marca objeto para armazenar
		manager.persist(a);
		manager.persist(l);

		// Exibe resultado
		System.out.println("Autor cadastrado com id " + a.getId());
		System.out.println("Livro cadastrado com id " + l.getId());

		// Comita transacao
		manager.getTransaction().commit();

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();
	}
}
