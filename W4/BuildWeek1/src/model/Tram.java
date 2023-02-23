package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Tram extends ParcoMezzi{

	@Column
	private Integer nPosti=80;

	public Tram() {
		super();
		
	}

	public Integer getnPosti() {
		return nPosti;
	}

	public void setnPosti(Integer nPosti) {
		this.nPosti = nPosti;
	}

	@Override
	public String toString() {
		return super.toString()+"Tram [nPosti=" + nPosti + "]";
	}
	
	

}
