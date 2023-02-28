package com.GodfathersPizza.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.GodfathersPizza.model.Coperto;
import com.GodfathersPizza.model.Ordine;
import com.GodfathersPizza.model.PostoVuoto;
import com.GodfathersPizza.model.Prodotto;
import com.GodfathersPizza.model.StatoOrdine;
import com.GodfathersPizza.model.Tavolo;

public class OrdersConfiguration {

	@Bean
	@Scope("prototype")
	public Ordine ordine(Tavolo tavolo, List<Prodotto> prodotti, StatoOrdine stato, String nota, int coperti) {
		Ordine ordine = new Ordine();
		ordine.setTavolo(tavolo);
		ordine.setProdotti(prodotti);
		ordine.setStato(stato);
		ordine.setNota(nota);
		ordine.setNumeroCoperti(coperti);
		return ordine;
	}
	
/*	@Bean
	@Scope("prototype")
	public Tavolo tavolo(int numeroCopertiMax, Coperto coperti[]) {
		Tavolo tavolo = new Tavolo();
		tavolo.setNumeroCopertiMax(numeroCopertiMax);
		tavolo.setCoperti(coperti);
		tavolo.setStato();
		return tavolo;
	}*/
	
	//tavoli liberi
	@Bean
	@Scope("prototype")
	public Tavolo tavolo(int numeroCopertiMax) {
		Tavolo tavolo = new Tavolo();
		tavolo.setNumeroCopertiMax(numeroCopertiMax);
		return tavolo;
	}
	
	@Bean
	@Scope("prototype")
	public Coperto coperto() {
		Coperto coperto = new Coperto();
		return coperto;
	}
	
	@Bean
	@Scope("prototype")
	public PostoVuoto postoVuoto() {
		PostoVuoto postoVuoto = new PostoVuoto();
		postoVuoto.setPrezzo(0.00);
		return postoVuoto;
	}

}
