package com.SpringBoot.GestionePrenotazioni;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.SpringBoot.GestionePrenotazioni.model.Postazione;
import com.SpringBoot.GestionePrenotazioni.model.Prenotazione;

public class PostazioneTest {
	Postazione p;
 
	@Test  
	public void checkDataPrTest() {      
		//true--> postazione già prenotata per la data inserita
        //false--> non c'è una prenotazione per quella data
		Prenotazione p1 = new Prenotazione();
		p1.setDataPrenotazione(LocalDate.parse("2024-12-13"));
		Prenotazione p2 = new Prenotazione();
		p2.setDataPrenotazione(LocalDate.parse("2023-10-11"));
	
		Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();
		prenotazioni.add(p1);
		prenotazioni.add(p2);
		
	    p = new Postazione();
		p.setPrenotazioni(prenotazioni);
		
		LocalDate d = LocalDate.parse("2024-12-13");
		
	    assertEquals(true, p.checkDataIfLibera(d.toString()));
	}

}
