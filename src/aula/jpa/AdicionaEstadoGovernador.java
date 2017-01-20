package aula.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaEstadoGovernador {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Cria manipulacao
		EntityManager manager = factory.createEntityManager();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria objeto 1
		Governador governador = new Governador();

		// Cria user input 1
		System.out.println("Digite o nome do Governador: ");
		governador.setNome(entrada.nextLine());

		// Cria objeto 2
		Estado estado = new Estado();

		// Cria user input 2
		System.out.println("Digite o nome do Estado: ");
		estado.setNome(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Insere na classe que possui o vinculo OneToOne
		estado.setGovernador(governador);

		// Abre transacao
		manager.getTransaction().begin();

		// Marca objeto para armazenar
		manager.persist(estado);
		manager.persist(governador);

		// Comita transaçao
		manager.getTransaction().commit();

		// Exibe resultado
		System.out.println("Estado cadastrado com id: " + estado.getId());
		System.out.println("Governador cadastrado com id: " + governador.getId());

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();

	}

}
