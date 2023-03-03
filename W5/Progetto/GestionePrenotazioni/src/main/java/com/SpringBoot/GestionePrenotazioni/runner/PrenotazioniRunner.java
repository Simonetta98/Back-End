package com.SpringBoot.GestionePrenotazioni.runner;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.SpringBoot.GestionePrenotazioni.model.Edificio;
import com.SpringBoot.GestionePrenotazioni.model.Postazione;
import com.SpringBoot.GestionePrenotazioni.model.Tipo;
import com.SpringBoot.GestionePrenotazioni.service.EdificioService;
import com.SpringBoot.GestionePrenotazioni.service.PostazioneService;
import com.SpringBoot.GestionePrenotazioni.service.UtenteService;

@Component
public class PrenotazioniRunner implements ApplicationRunner {
	
	static Logger log = LoggerFactory.getLogger(PrenotazioniRunner.class);
	
	@Autowired 
    EdificioService edificioSrv;
	@Autowired 
	PostazioneService postazioneSrv;
	@Autowired 
	UtenteService utenteSrv;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("PrenotazioniRunning...");
		
		
		creaEdificio();
		
		

	}
	
	public void creaEdificio() {
		Edificio edificio = new Edificio();
		edificio.setNome_edificio("Edificio-tre");
		edificio.setCitta("Milano");
		edificio.setIndirizzo("Corso Europa");
		
		edificioSrv.saveEdificio(edificio);
		System.out.println(edificio);
		//log.info("Edificio creato in DB");
	}
	public Postazione creaPostazione() {
		Postazione p = new Postazione();
		p.setTipo(Tipo.SALA_RIUNIONI);
		p.setDescrizione("Sala grande");
		p.setNumero_max_occupanti(10);
		//p.setEdificio(null);
		//p.setPrenotazioni(null);
		
		System.out.println(p);
		return p;
		//postazioneSrv.savePostazione(p);
		//log.info("Postazione creato in DB");
	}
   public Set<Postazione> givePostazioniToEdificio() {
		Set<Postazione> p = new HashSet<Postazione>();
		Postazione p1 = postazioneSrv.getPostazioneByID(1l);
		Postazione p2 = postazioneSrv.getPostazioneByID(2l);
		Postazione p3 = postazioneSrv.getPostazioneByID(3l);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		
		return p;
	}
	
	public void effettuaPrenotazione() {
		
	}

}
