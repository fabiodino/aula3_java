package grana;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ReceitaRepositorio {

	// Abre manipulacao
	private EntityManager manager;

	// Cria construtor
	public ReceitaRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	// Marca objeto para armazenar
	public void adiciona(Receita receita) {
		this.manager.persist(receita);
	}

	// Marca objeto para remover
	public void remove(Receita receita) {
		this.manager.remove(receita);
	}

	// Retorna soma receita ate data
	public Double somaReceitaAte(Calendar data) {
		String jpql = "SELECT SUM(x.valor) FROM Receita x WHERE x.data <= :data";
		TypedQuery<Double> query = this.manager.createQuery(jpql, Double.class);
		query.setParameter("data", data);
		return query.getSingleResult();
	}

	// Retorna soma receitas periodo
	public Double somaReceitas(Calendar dataInicial, Calendar dataFinal) {
		String jpql = "SELECT SUM(x.valor) FROM Receita x WHERE" + "x.data >= :dataInicial AND x.data <= :dataFinal";
		TypedQuery<Double> query = this.manager.createQuery(jpql, Double.class);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);
		return query.getSingleResult();
	}

	// Retorna busca periodo
	public List<Receita> buscaPorPeriodo(Calendar dataInicial, Calendar dataFinal) {
		String jpql = "SELECT x FROM Receita x WHERE x.data >= :data" + "AND x.data <= :dataFinal ORDER BY x.data";
		TypedQuery<Receita> query = this.manager.createQuery(jpql, Receita.class);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);
		return query.getResultList();
	}

	// Retorna busca recentes
	public List<Receita> buscaRecentes() {
		String jpql = "SELECT x FROM Receitas x ORDER BY x.id DESC";
		TypedQuery<Receita> query = this.manager.createQuery(jpql, Receita.class);
		query.setMaxResults(10);
		return query.getResultList();
	}

}
