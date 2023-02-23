package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Abbonamento;
import model.Tessera;
import model.Utente;
import utils.JpaUtil;

public class AbbonamentoDAO {
	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	
	
	// SALVA abbonamento
		public static void saveAbbonamento (Abbonamento u) {
			
		t.begin();
		em.persist(u);
		t.commit();
		System.out.println("Abbonamento aggiunto al data base");

			
		}
		
	//CERCA abonnamneto
		public static Abbonamento cercaAbbonamento(Integer id_abbonamento) {
				t.begin();
			Abbonamento u=	em.find(Abbonamento.class, id_abbonamento);
			t.commit();
			System.out.println("Abbonamneto ricercato secondo id: "+id_abbonamento);
			return u;
		
	}
		
	// ELIMINA BY ID tessera
	public static void deletaUtente(Integer id) {
		
		Abbonamento tes= cercaAbbonamento(id);
	    t.begin();
	    em.remove(tes);
	    t.commit();
	    System.out.println("Abbonamento eliminato");
	}
		
		// MODIFICA Abbonamento
	public static void modificaAbbonamento(Abbonamento u) {
		
		t.begin();
	    em.merge(u);
	    t.commit();
		
		System.out.println("Abbonamento modificato");
		
	}
	
	public static void checkValiditaAbb(Utente u) {
		Tessera tess = u.getTessera();
		Abbonamento abb = tess.getAbbonamento();
		if(abb.isValidita() == true) {
			System.out.println("Abbonamento valido!");
		}else
			System.out.println("Abbonamento non valido!");
	}
}
