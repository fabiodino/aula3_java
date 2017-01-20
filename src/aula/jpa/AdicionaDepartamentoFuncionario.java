package aula.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaDepartamentoFuncionario {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria objeto 1
		Departamento d = new Departamento();

		// Cria user input 1
		System.out.println("Digite o nome do departamento: ");
		d.setNome(entrada.nextLine());

		// Cria objeto 2
		Funcionario f = new Funcionario();

		// Cria user input 2
		System.out.println("Digite o nome do funcionario: ");
		f.setNome(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Insere na classe alvo atraves da classe que possui o vinculo
		// OneToMany
		d.getFuncionarios().add(f);

		// Abre transacao
		manager.getTransaction().begin();

		// Marca objeto para armazenar
		manager.persist(d);
		manager.persist(f);

		// Comita transacao
		manager.getTransaction().commit();

		// Exibe resultado
		System.out.println("Departamento cadastrado com id: " + d.getId());
		System.out.println("Funcionario cadastrado com id: " + f.getId());

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();

	}

}
