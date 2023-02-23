package dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.ParcoMezzi;
import model.Utente;
import utils.JpaUtil;

public class ParcoMezziDAO {
	
	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	// SALVA ParcoMezzi
			public static void saveMezzo (ParcoMezzi u) {
				
			t.begin();
			em.persist(u);
			t.commit();
			System.out.println("Mezzo aggiunto al data base");
				
			}
			
			//CERCA Mezzo
			public static ParcoMezzi cercaMezzo(Integer id_mezzo) {
					t.begin();
				ParcoMezzi u=	em.find(ParcoMezzi.class, id_mezzo);
				t.commit();
				System.out.println("Mezzo ricercato secondo id: "+id_mezzo);
				return u;
			
		}
	
	// ELIMINA BY ID Mezzo
		public static void deletaMezzo(Integer id) {
			
			ParcoMezzi tes= cercaMezzo(id);
		    t.begin();
		    em.remove(tes);
		    t.commit();
		    System.out.println("Mezzo eliminato");
		}
			
			// MODIFICA ParcoMezzi
		public static void modificaMezzo(ParcoMezzi u) {
			
			t.begin();
		    em.merge(u);
		    t.commit();
			
			System.out.println("Mezzo modificato");
			
		}
		
		public static void vidimaBiglietto(ParcoMezzi mezzo, Utente u) {
			mezzo.vidimaBigl(u);
			System.out.println("Biglietto vidimato da: " + u.getNome());
		}
		
		public static void mandaInManutenzione(ParcoMezzi p) {
			if(p.isInServizio()==true) {
				p.setInServizio(false);
				p.setDataInizioManutenzione(LocalDate.now());
				modificaMezzo(p);
				System.out.println("Mezzo in manutenzione");
			}else {
				System.out.println("Mezzo già in manutenzione");
			}
		}
		public static void fineManutenzione(ParcoMezzi p) {
			if(p.isInServizio()==false) {
				p.setInServizio(true);
				p.setDataFineManutenzione(LocalDate.now());
				modificaMezzo(p);
				System.out.println("Manutenzione finita");
			}else {
				System.out.println("Mezzo non in manutenzione");
			}
		}
		

}
