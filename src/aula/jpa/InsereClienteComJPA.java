package aula.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsereClienteComJPA {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Cria objeto
		Cliente c = new Cliente();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria user input
		System.out.println("Digite o nome do cliente: ");
		c.setNome(entrada.nextLine());

		System.out.println("Digite o cpf do cliente: ");
		c.setCpf(entrada.nextLine());

		// Cria objeto classe intermediaria
		Endereco e = new Endereco();

		// Acessa classe Endereco pela classe Cliente
		c.setEndereco(e);

		// Cria user input
		System.out.println("Digite o endereco do cliente: ");

		System.out.println("Pais: ");
		e.setPais(entrada.nextLine());

		System.out.println("Estado: ");
		e.setEstado(entrada.nextLine());

		System.out.println("Cidade: ");
		e.setCidade(entrada.nextLine());

		System.out.println("Logradouro: ");
		e.setLogradouro(entrada.nextLine());

		System.out.println("Numero: ");
		e.setNumero(entrada.nextLine());

		System.out.println("Complemento: ");
		e.setComplemento(entrada.nextLine());

		System.out.println("CEP: ");
		e.setCep(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Marca objeto para armazenar
		manager.persist(c);

		// Abre transacao
		manager.getTransaction().begin();

		// Comita transacao
		manager.getTransaction().commit();

		// Exibe resultado
		System.out.println("Cliente cadastrado com id: " + c.getId());

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();
	}
}
