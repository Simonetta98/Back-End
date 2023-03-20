package com.GestioneIncendi.sonda;

import com.GestioneIncendi.processoControllo.EventManager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Sonda {

	private long idSonda;
	private double latitude;
	private double longitude;
	private int smokeLevel;
	//EventManager
	public EventManager em;
	
	public Sonda() {
	        this.em = new EventManager("emissione_di_dati");
	    }
	public void dataEmission() {
		SondaDto data = new SondaDto();
		data.setIdSonda(idSonda);
		data.setLatitude(latitude);
		data.setLongitude(longitude);
		data.setSmokeLevel(smokeLevel);
		
		em.notify("emissione_di_dati", data);	
	}
	
	
}
