package aula.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Inicializar unidade de persistência
public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		factory.close();
	}
}
