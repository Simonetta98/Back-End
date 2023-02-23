package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Abbonamento;
import model.Utente;
import utils.JpaUtil;

public class UtenteDAO {
//	  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("buildWeek");
//	private static final EntityManager em = emf.createEntityManager();
//	private static final EntityTransaction t = em.getTransaction();
	
	private static final EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t=em.getTransaction();
	
	
	
	
	// SALVA UTENTE
	public static void saveUtente (Utente u) {
		
	t.begin();
	em.persist(u);
	t.commit();
	System.out.println("Utente aggiunto al data base");

		
	}
	
	//CERCA UTENTE
	public static Utente cercaUtente(Integer id_utente) {
			t.begin();
		Utente u=	em.find(Utente.class, id_utente);
		t.commit();
		System.out.println("Utente ricercato secondo id: "+id_utente);
		return u;
	
}
	
// ELIMINA BY ID UTENTE
public static void deletaUtente(Integer id) {
	
	Utente ut= cercaUtente(id);
    t.begin();
    em.remove(ut);
    t.commit();
    System.out.println("Utente eliminato");
}
	
	// MODIFICA UTENTE
public static void modificaUtente(Utente u) {
	
	t.begin();
    em.merge(u);
    t.commit();
	
	System.out.println("Utente modificato");
	
}



}
