package com.GodfathersPizza.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Ordine {
	private static final AtomicInteger idGenerator = new AtomicInteger(1);
	
	private long numeroOrdine = idGenerator.getAndIncrement();
	private Tavolo tavolo;
	private List<Prodotto> prodotti;
	private StatoOrdine stato;
	private int numeroCoperti;
	private double totale;
	private String nota;
	private String orario = currentHour();
	
	public String currentHour() {
		Date date = new Date();  
		Calendar calendar = GregorianCalendar.getInstance(); 
		calendar.setTime(date); 
		return calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE); 
	}
	
	public double calcolaTotale() {
		List<Double> prezzi = new ArrayList<Double>();
		Coperto cop = new Coperto();
		for (Prodotto p : prodotti) {
           double prezzo = p.getPrezzo();
           prezzi.add(prezzo);
        }
		 double sum = prezzi.stream().reduce((x, y) -> x + y).get();
	     double finalSum = sum + (cop.getPrezzo() * numeroCoperti);
	     
	     return finalSum; 
	}	
	
	
}
