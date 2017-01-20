package aula.jpa;

import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaFaturaLigacao {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria objeto 1
		Ligacao ligacao1 = new Ligacao();

		// Cria user input 1
		System.out.println("Digite o tempo de duracao da ligacao 1: ");
		ligacao1.setDuracao(Integer.parseInt(entrada.nextLine()));

		// Cria objeto 2
		Ligacao ligacao2 = new Ligacao();

		// Cria user input 2
		System.out.println("Digite o tempo de duracao da ligacao 2: ");
		ligacao2.setDuracao(Integer.parseInt(entrada.nextLine()));

		// Cria objeto
		Fatura fatura = new Fatura();

		// Cria user input
		fatura.setVencimento(new GregorianCalendar(2012, 11, 20));

		// Fecha entrada
		entrada.close();

		fatura.getLigacoes().add(ligacao1);
		fatura.getLigacoes().add(ligacao2);

		ligacao1.setFatura(fatura);
		ligacao2.setFatura(fatura);

		// Abre transacao
		manager.getTransaction().begin();

		// Marca objeto para armazenar
		manager.persist(fatura);
		manager.persist(ligacao1);
		manager.persist(ligacao2);

		// Comita transacao
		manager.getTransaction().commit();

		// Exibe resultado
		System.out.println("Fatura cadastrada com id: " + fatura.getId());
		System.out.println("ligacao1 cadastrada com id: " + ligacao1.getId());
		System.out.println("ligacao2 cadastrada com id: " + ligacao2.getId());

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();

	}
}
