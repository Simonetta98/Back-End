package model;

import javax.persistence.Entity;

@Entity
public class RivenditoreAutorizzato extends PuntoEmissione {

	public RivenditoreAutorizzato() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString()+"RivenditoreAutorizzato []";
	}

}
