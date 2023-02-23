package model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Autobus extends ParcoMezzi{

	
	@Column
	private Integer nPostiDisponibili=110;
	
	

	public Integer getnPosti() {
		return nPostiDisponibili;
	}

	public void setnPosti(Integer nPosti) {
		this.nPostiDisponibili = nPosti;
	}

	public Autobus() {
		super();
		
	}

	@Override
	public String toString() {
		return super.toString()+"Autobus [nPosti=" + nPostiDisponibili + "]";
	}
	
	
	
}
