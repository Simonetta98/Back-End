package control;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.ParcoMezziDAO;
import dao.PuntoEmissioneDAO;
import dao.TesseraDAO;
import dao.TrattaDAO;
import dao.UtenteDAO;
import enums.Arrivi;
import enums.DurataAbb;
import enums.Partenze;
import model.*;
import utils.JpaUtil;

public class MainProject {
	private static final EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t=em.getTransaction();
	public static void main(String[] args) {
		
		try {
			
	//UTENTI
		Utente u = new Utente();
		u.setNome("Simona");
		u.setCognome("Neri");
		//UtenteDAO.saveUtente(u);
		Utente u1 = UtenteDAO.cercaUtente(1);
		Utente u2 = UtenteDAO.cercaUtente(2);
		Utente u3 = UtenteDAO.cercaUtente(3);
		
		
	//PUNTI EMISSIONE
		DistributoreAutomatico distrubutore = new DistributoreAutomatico();
		RivenditoreAutorizzato rivenditore = new RivenditoreAutorizzato();
		
		//PuntoEmissioneDAO.savePunto(rivenditore);
		PuntoEmissione punto1 = PuntoEmissioneDAO.cercaPunto(6);
		PuntoEmissione punto2 = PuntoEmissioneDAO.cercaPunto(7);
		
	//TRATTE
		Tratta tratta = new Tratta();
		tratta.setPartenza(Partenze.Castellamare);
		tratta.setArrivo(Arrivi.StrangolaGalli);
		tratta.setDurataMediaTrattainMinuti(250);
		//TrattaDAO.saveTratta(tratta);
		Tratta t1 = TrattaDAO.cercaTratta(1);
		Tratta t2 = TrattaDAO.cercaTratta(2);
		Tratta t3 = TrattaDAO.cercaTratta(3);
		
		
		
	//MEZZI
		
		Tram tram = new Tram();
		tram.setTratta(t2);
		//ParcoMezziDAO.saveMezzo(tram);
		
		Autobus autobus = new Autobus();
		autobus.setTratta(t3);
		//ParcoMezziDAO.saveMezzo(autobus);
		
		ParcoMezzi tram1 = ParcoMezziDAO.cercaMezzo(8);
		ParcoMezzi tram2 = ParcoMezziDAO.cercaMezzo(9);
		ParcoMezzi autobus1 = ParcoMezziDAO.cercaMezzo(10);
		
		
	//TESSERA UTENTE
		
		//TesseraDAO.creaTesseract(u1);  //risalva utente in db 
		
	    //PuntoEmissioneDAO.compraAbbonamento(u2, punto1, DurataAbb.SETTIMANALE); //non ha la tessera, quindi gliela genera
	    //PuntoEmissioneDAO.compraAbbonamento(u1, punto1, DurataAbb.MENSILE); //lui ha la tessera, e gli fa solo abbonamento
	    
	//BIGLIETTI
			
	    //PuntoEmissioneDAO.compraBiglietto(u3, punto2);	
	    //PuntoEmissioneDAO.compraBiglietto(u3, punto2);
	  
	//VIDIMA BIGLIETTO
	    
	    //ParcoMezziDAO.vidimaBiglietto(autobus1, u3);
	   //ParcoMezziDAO.vidimaBiglietto(tram1, u3);
		
	//MEZZO CHE PARTE
		
	 //autobus1.corri(t1);
	 //tram1.corri(t2);
	  
	//MANDIAMO MEZZO IN ANUTENZIONE
		//ParcoMezziDAO.mandaInManutenzione(tram2);
		//ParcoMezziDAO.fineManutenzione(tram2);  //da fare domani 
		
	//info MANUTENZIONE
		infoManutenzione(tram2);
		infoManutenzione(tram1);
			
		autobus1.tempoEffettivo();
		tram1.tempoEffettivo();
			
			
  //QUERY
		bigliettiPerDate(LocalDate.parse("2023-02-22"), LocalDate.parse("2023-02-25"));
			
		abbonamentoPerDate(LocalDate.parse("2023-02-22"), LocalDate.parse("2023-02-25"));
		
		bigliettiVidimatiPerDate(LocalDate.parse("2023-02-22"), LocalDate.parse("2023-02-25"));
			
			
			
			
		} catch(Exception e) {
			em.getTransaction().rollback();
		}finally {
            em.close();
        
        }
	
	}
	
	public static List<Biglietto> bigliettiPerDate(LocalDate a, LocalDate b) {
		Query query = em.createQuery("SELECT ele FROM Biglietto ele WHERE ele.data_emissione > :a AND ele.data_emissione < :b");
		query.setParameter("a", a);
		query.setParameter("b", b);
		
		List<Biglietto> results = query.getResultList();
		for(Biglietto ap:results) {
    		System.out.println(ap);
    	}
		return results;
		
		
	}
	
	public static List<Abbonamento> abbonamentoPerDate(LocalDate a, LocalDate b) {
		Query query = em.createQuery("SELECT ele FROM Abbonamento ele WHERE ele.data_emissione > :a AND ele.data_emissione < :b");
		query.setParameter("a", a);
		query.setParameter("b", b);
		
		List<Abbonamento> results = query.getResultList();
		for(Abbonamento ap:results) {
    		System.out.println(ap);
    	}
		return results;

	}
	
	public static List<Biglietto> bigliettiVidimatiPerDate(LocalDate a, LocalDate b) {
		Query query = em.createQuery("SELECT ele FROM Biglietto ele WHERE ele.data_vidima > :a AND ele.data_vidima < :b");
		query.setParameter("a", a);
		query.setParameter("b", b);
		
		List<Biglietto> results = query.getResultList();
		for(Biglietto ap:results) {
    		System.out.println(ap);
    	}
		return results;
		
	}
	
	public static void infoManutenzione(ParcoMezzi p) {
		if(p.isInServizio()==false) {
			System.out.println("Mezzo in manutenzione da: " + p.getDataInizioManutenzione());
		}else {
			System.out.println("Mezzo in servizio");
			if(p.getDataInizioManutenzione()==null) {
				System.out.println("Il mezzo non è mai stato in manutenzione");
			}else {
				System.out.println("Ultima manutenzione: " + p.getDataInizioManutenzione() + "/" + p.getDataFineManutenzione());
			}
		}
	}
	
	

}
