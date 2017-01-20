package aula.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estado {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@OneToOne
	private Governador governador;

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the governador
	 */
	public Governador getGovernador() {
		return governador;
	}

	/**
	 * @param governador
	 *            the governador to set
	 */
	public void setGovernador(Governador governador) {
		this.governador = governador;
	}

}
