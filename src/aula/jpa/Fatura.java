package aula.jpa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Fatura {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "fatura") // Relacionamento bidirecional
	private Collection<Ligacao> ligacoes = new ArrayList<Ligacao>();

	@Temporal(TemporalType.DATE)
	private Calendar vencimento;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the ligacoes
	 */
	public Collection<Ligacao> getLigacoes() {
		return ligacoes;
	}

	/**
	 * @param ligacoes
	 *            the ligacoes to set
	 */
	public void setLigacoes(Collection<Ligacao> ligacoes) {
		this.ligacoes = ligacoes;
	}

	/**
	 * @return the vencimento
	 */
	public Calendar getVencimento() {
		return vencimento;
	}

	/**
	 * @param vencimento
	 *            the vencimento to set
	 */
	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

}
