package com.SpringBoot.GestionePrenotazioni.runner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.SpringBoot.GestionePrenotazioni.model.Edificio;
import com.SpringBoot.GestionePrenotazioni.model.Postazione;
import com.SpringBoot.GestionePrenotazioni.model.Prenotazione;
import com.SpringBoot.GestionePrenotazioni.model.Tipo;
import com.SpringBoot.GestionePrenotazioni.model.Utente;
import com.SpringBoot.GestionePrenotazioni.service.EdificioService;
import com.SpringBoot.GestionePrenotazioni.service.PostazioneService;
import com.SpringBoot.GestionePrenotazioni.service.PrenotazioneService;
import com.SpringBoot.GestionePrenotazioni.service.UtenteService;

@Component
public class PrenotazioniRunner implements ApplicationRunner {
	
	static Logger log = LoggerFactory.getLogger(PrenotazioniRunner.class);
	
	@Autowired EdificioService edificioSrv;
	@Autowired PostazioneService postazioneSrv;
	@Autowired UtenteService utenteSrv;
	@Autowired PrenotazioneService prenotazioneSrv;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("PrenotazioniRunning...");
		
		
		//creaEdificio();
		//creaPostazione();
		
		//giveEdificioToPostazioni(3l);
		//getInfoEdificio(1l);
		
		//creaUtente();
		//effettuaPrenotazione(3l, 2l, "2025-02-11");
		//getInfoPrenotazione(3l);
		
		//ricercaPostazionePerTipoECitta(Tipo.OPENSPACE, "Milano");
		
		//checkValiditaPrenotazione(1l);
		
		
	}
	
	public void creaEdificio() {
		Edificio e = new Edificio();
		e.setNome_edificio("Edificio-cinque");
		e.setCitta("Milano");
		e.setIndirizzo("Via Francesco Sforza");
		
		//System.out.println(edificio);
		edificioSrv.saveEdificio(e);
		log.info("Edificio creato in DB");
	}
	
	public void creaPostazione() {
		Postazione p = new Postazione();
		p.setTipo(Tipo.OPENSPACE);
		p.setDescrizione("Sala piccola");
		p.setNumero_max_occupanti(4);

		//System.out.println(p);
		postazioneSrv.savePostazione(p);
		log.info("Postazione creata in DB");
	}
	
	public void creaUtente() {
		Utente u = new Utente();
		u.setNome_completo("Pina Pinetta");
		u.setUsername("pinuccia60");
		u.setEmail("pina20@gmail.com");
		
		//System.out.println(u);
		utenteSrv.saveUtente(u);
		log.info("Utente creato in DB");
	}
	
   public void giveEdificioToPostazioni(Long id) {
	    Edificio ed = edificioSrv.getEdificioByID(id);
		Set<Postazione> p = new HashSet<Postazione>();
		Postazione p1 = postazioneSrv.getPostazioneByID(5l);
		Postazione p2 = postazioneSrv.getPostazioneByID(6l);
		p.add(p1);
		p.add(p2);
		p.forEach(e->{
			e.setEdificio(ed);
			postazioneSrv.updatePostazione(e);
		});
		edificioSrv.updateEdificio(ed);
		log.info("Postazioni assegnate con successo");
	}
   
   public void getInfoEdificio(Long id) {
	   edificioSrv.printInfo(id);
    }
   
	//checkTestati                                                                        //parametri:
   public void effettuaPrenotazione(Long id_u, Long id_p, String data) {    //ID utente che vuole prenotare +
		Prenotazione prenota = new Prenotazione();                          //ID postazione da prenotare +
		Utente u = utenteSrv.getUtenteByID(id_u);                           //Data da prenotare "YYYY-MM-DD"
		Postazione p = postazioneSrv.getPostazioneByID(id_p);
		
		if(p.isLibera() || p.checkDataIfLibera(data)==false && u.checkDateUtente(data)==false) {  // controllo se la postazione è libera 
			prenota.setUtente(u);                                                                 // o se per quella data è già stata prenotata
			prenota.setPostazione(p);                                                             // e se l'utente ha già una prenotazione per quella data
			prenota.setDataPrenotazione(LocalDate.parse(data));
			
			p.setLibera(false);
			
			//System.out.println(prenota);
			
			prenotazioneSrv.savePrenotazione(prenota);
			postazioneSrv.updatePostazione(p);
			log.info("Prenotazione effettuata con successo");
			
		}else if(u.checkDateUtente(data)) {
			log.info("ERROE: hai già prenotato una postazione per quella data");
		}else if(p.checkDataIfLibera(data)) {
			log.info("ERROE: la postazione è già prenotata per quella data");
		}
    }
   
   public void getInfoPrenotazione(Long id) {
	   prenotazioneSrv.printInfo(id);
    }
   

   public void checkValiditaPrenotazione(Long id) {
	   Prenotazione p = prenotazioneSrv.getPrenotazioneByID(id);
	   LocalDate d = p.getDataPrenotazione();
	   LocalDate today = LocalDate.now();
	   if(today.isAfter(d)) {
		  Postazione postazione = p.getPostazione();
		  postazione.setLibera(true);
		  postazioneSrv.updatePostazione(postazione);
		  prenotazioneSrv.removePrenotazione(p);
		  log.info("Ops... la prenotazione è scaduta");
	   }else {
		   log.info("La prenotazione è ancora valida");
	   }
   }
   
   //testato
   public void ricercaPostazionePerTipoECitta(Tipo tipo, String citta) {
	  List<Edificio> listE = edificioSrv.getEdificioByCitta(citta);
	  List<Postazione> request = listE.stream().flatMap(e -> e.getPostazioni().stream())
      .filter(c -> c.getTipo().equals(tipo))
      .collect(Collectors.toList());
	  if(request.size()==0) {
		  log.info("Ops... nessuna postazione di queso tipo trovata nella città " + citta.toUpperCase());
	  }else {
		  System.out.println("POSTAZIONI TROVATE: " + request.size());
		  System.out.println("PER LA CITTA: " + citta);
		  request.forEach(e->System.out.println(e));
	  }
  
   }
   

}
