package com.SpringBoot.GestionePrenotazioni;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.SpringBoot.GestionePrenotazioni.model.Edificio;
import com.SpringBoot.GestionePrenotazioni.model.Postazione;
import com.SpringBoot.GestionePrenotazioni.model.Tipo;

public class PrenotazioniTest {

	@Test
	public void testTrovaPerCittaTipo() {
		Postazione p1 = new Postazione();
		p1.setTipo(Tipo.OPENSPACE);
		Postazione p2 = new Postazione();
		p2.setTipo(Tipo.OPENSPACE);
		Postazione p3 = new Postazione();
		p3.setTipo(Tipo.SALA_RIUNIONI);
		Postazione p4 = new Postazione();
		p4.setTipo(Tipo.PRIVATO);
		
		Set<Postazione> postazioni1 = new HashSet<Postazione>();
		postazioni1.add(p1);
		postazioni1.add(p2);
		postazioni1.add(p3);
		Set<Postazione> postazioni2 = new HashSet<Postazione>();
		postazioni2.add(p4);
		postazioni2.add(p2);
		postazioni2.add(p3);
		
		List<Edificio> ed = new ArrayList<Edificio>();
		Edificio e1 = new Edificio();
		e1.setCitta("Milano");
		e1.setId_edificio(1l);
		e1.setIndirizzo("viabla");
		e1.setNome_edificio("ed1");
		e1.setPostazioni(postazioni1);
		Edificio e2 = new Edificio();
		e2.setCitta("Genova");
		e2.setId_edificio(2l);
		e2.setIndirizzo("viablabla");
		e2.setNome_edificio("ed2");
		e2.setPostazioni(postazioni2);

		ed.add(e1);
		ed.add(e2);
		//System.out.println(ed.size());
		
	String nome = "Milano";
	Tipo tipo = Tipo.OPENSPACE;
	List<Edificio> requested =	ed.stream().filter(e->e.getCitta().equals(nome)).collect(Collectors.toList());
		
	//System.out.println(requested.size());
	
	if(requested!=null) {
			List<Postazione> req2 =  requested.stream().flatMap(e -> e.getPostazioni().stream())
				      .filter(c -> c.getTipo().equals(tipo))
				      .collect(Collectors.toList());
			
			//System.out.println(req2.size());
	     	assertEquals(2, req2.size());
		}
		
	}
}
