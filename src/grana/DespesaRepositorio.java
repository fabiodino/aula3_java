package grana;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DespesaRepositorio {

	// Abre manipulacao
	private EntityManager manager;

	// Cria construtor
	public DespesaRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	// Marca objeto para armazenar
	public void adiciona(Despesa despesa) {
		this.manager.persist(despesa);
	}

	// Marca objeto para remover
	public void remove(Despesa despesa) {
		this.manager.remove(despesa);
	}

	// Retorna soma despesas ate data
	public Double somaDespesasAte(Calendar data) {
		String jpql = "SELECT SUM(x.valor) FROM Despesa x WHERE x.data <= :data";
		TypedQuery<Double> query = this.manager.createQuery(jpql, Double.class);
		query.setParameter("data", data);
		return query.getSingleResult();
	}

	// Retorna soma despesas periodo
	public Double somaDespesas(Calendar dataInicial, Calendar dataFinal) {
		String jpql = "SELECT SUM(x.valor) FROM Despesa x WHERE" + "x.data >= :dataInicial AND x.data <= :dataFinal";
		TypedQuery<Double> query = this.manager.createQuery(jpql, Double.class);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);
		return query.getSingleResult();
	}

	// Retorna busca periodo
	public List<Despesa> buscaPorPeriodo(Calendar dataInicial, Calendar dataFinal) {
		String jpql = "SELECT x FROM Despesa x WHERE x.data >= :dataInicial"
				+ "AND x.data <= :dataFinal ORDER BY x.data";
		TypedQuery<Despesa> query = this.manager.createQuery(jpql, Despesa.class);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);
		return query.getResultList();
	}

	// Retorna busca recente
	public List<Despesa> buscaRecentes() {
		String jpql = "SELECT x FROM Despesa x ORDER BY x.id DESC";
		TypedQuery<Despesa> query = this.manager.createQuery(jpql, Despesa.class);
		query.setMaxResults(10);
		return query.getResultList();
	}
}
