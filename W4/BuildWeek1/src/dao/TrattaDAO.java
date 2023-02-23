package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Tratta;
import utils.JpaUtil;

public class TrattaDAO {

	private static final EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t=em.getTransaction();
	
	
	// SALVA TRATTA
	public static void saveTratta (Tratta u) {
		
	t.begin();
	em.persist(u);
	t.commit();
	System.out.println("Tratta aggiunto al data base");

		
	}
	
	//CERCA TRATTA
	public static Tratta cercaTratta(Integer id) {
			t.begin();
		Tratta u=	em.find(Tratta.class, id);
		t.commit();
		System.out.println("Tratta ricercato secondo id: "+id);
		return u;
	
}
	
// ELIMINA BY ID TRATTA
public static void deletaUtente(Integer id) {
	
	Tratta ut= cercaTratta(id);
    t.begin();
    em.remove(ut);
    t.commit();
    System.out.println("Tratta eliminato");
}
	
	// MODIFICA TRATTA
public static void modificaTratta(Tratta u) {
	
	t.begin();
    em.merge(u);
    t.commit();
	
	System.out.println("Tratta modificato");
	
}

}
