package aula.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoveEditoraComJPA {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria user input
		System.out.println("Digite o id da editora que deseja remover: ");
		Long id = Long.parseLong(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Busca informacao do objeto no BD
		Editora e = manager.find(Editora.class, id);

		// Marca objeto para remover
		manager.remove(e);

		// Abre transacao
		manager.getTransaction().begin();

		// Comita transacao
		manager.getTransaction().commit();

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();

	}

}
