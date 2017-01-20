package aula.jpa;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaPedidoConsumidor {

	public static void main(String[] args) {

		// Abre conexao
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		// Abre manipulacao
		EntityManager manager = factory.createEntityManager();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria objeto 1
		Consumidor c = new Consumidor();

		// Cria user input 1
		System.out.println("Digite o nome do consumidor: ");
		c.setNome(entrada.nextLine());

		// Cria objeto 2
		Pedido p = new Pedido();

		// Cria input 2
		System.out.println("Registrando data do pedido...");
		p.setData(Calendar.getInstance());

		// Fecha entrada
		entrada.close();

		// Insere na classe que possui o vinculo ManyToOne
		p.setConsumidor(c);

		// Abre transacao
		manager.getTransaction().begin();

		// Marca objeto para armazenar
		manager.persist(c);
		manager.persist(p);

		// Comita transacao
		manager.getTransaction().commit();

		// Exibe resultado
		System.out.println("Consumidor cadastrado com id: " + c.getId());
		System.out.println("Pedido cadastrado com id: " + p.getId());

		// Fecha manipulacao
		manager.close();

		// Fecha conexao
		factory.close();
	}

}
