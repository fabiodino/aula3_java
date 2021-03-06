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

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria objeto 1
		Autor a = new Autor();

		// Cria user input 1
		System.out.println("Digite o nome do autor: ");
		a.setNome(entrada.nextLine());

		// Cria objeto 2
		Livro l = new Livro();

		// Cria user input 2
		System.out.println("Digite o nome do livro: ");
		l.setNome(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Insere na classe que possui o vinculo OneToOne
		l.getAutores().add(a);

		// Abre transacao
		manager.getTransaction().begin();

		// Marca objeto para armazenar
		manager.persist(a);
		manager.persist(l);

		// Comita transacao
		manager.getTransaction().commit();

		// Exibe resultado
		System.out.println("Autor cadastrado com id " + a.getId());
		System.out.println("Livro cadastrado com id " + l.getId());

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();
	}
}
