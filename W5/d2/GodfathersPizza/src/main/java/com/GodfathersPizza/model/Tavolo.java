package com.GodfathersPizza.model;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Tavolo {
	
	private static final AtomicInteger idGenerator = new AtomicInteger(1);

	private int numeroTavolo = idGenerator.getAndIncrement();
	private int numeroCopertiMax;
	private Coperto coperti[];
	private Stato stato = Stato.LIBERO;
	

	public void setNumeroTavolo(int numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
	}

	public void setNumeroCopertiMax(int numeroCopertiMax) {
		this.numeroCopertiMax = numeroCopertiMax;
	}

	public void setCoperti(Coperto[] coperti) {
		if(numeroCopertiMax <= coperti.length) {
			this.coperti = coperti;
		}else {
			System.out.println("Il tavolo è pieno, il massimo di posti è: " + numeroCopertiMax);
		}
		
	}

	public void setStato() {
		if(this.coperti.length > 0) {
			this.stato = Stato.OCCUPATO;
		}
		
	}
	
}
