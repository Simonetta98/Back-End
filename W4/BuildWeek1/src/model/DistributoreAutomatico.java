package model;

import javax.persistence.*;

@Entity
public class DistributoreAutomatico extends PuntoEmissione {
	@Column(nullable=false)
	private boolean attivo;
	

	public DistributoreAutomatico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	@Override
	public String toString() {
		return super.toString()+"DistributoreAutomatico [attivo=" + attivo + "]";
	}
}
