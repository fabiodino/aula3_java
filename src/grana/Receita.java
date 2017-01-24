package grana;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Receita {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private Double valor;

	private Calendar data;

	private String tipo;

	@Override // caso o metodo pai seja alterado, aqui tem que alterar tb
	public String toString() {
		String s = this.nome + " - ";
		s += this.valor + " - ";
		s += this.tipo + " - ";

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		s += sdf.format(this.data.getTime());

		return s;
	}

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
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the data
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Calendar data) {
		this.data = data;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
