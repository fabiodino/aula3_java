package aula.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsereEditoraComJPA {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Cria objeto
		Editora novaEditora = new Editora();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria user input
		System.out.println("Digite o nome da editora: ");
		novaEditora.setNome(entrada.nextLine());

		System.out.println("Digite o email da editora: ");
		novaEditora.setEmail(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Marca objeto para armazenar
		manager.persist(novaEditora);

		// Abre transacao
		manager.getTransaction().begin();

		// Comita transacao
		manager.getTransaction().commit();

		// Exibe resultado
		System.out.println("Editora cadastrada com id: " + novaEditora.getId());

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();

	}
}
