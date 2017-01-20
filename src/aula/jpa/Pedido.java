package aula.jpa;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
	private Calendar data;

	// Entidade alvo
	@ManyToOne
	private Consumidor consumidor;

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
	 * @return the consumidor
	 */
	public Consumidor getConsumidor() {
		return consumidor;
	}

	/**
	 * @param consumidor
	 *            the consumidor to set
	 */
	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

}
