package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Tessera;
import model.Utente;
import utils.JpaUtil;

public class TesseraDAO {

	private static final EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t=em.getTransaction();
	
	
	
	
	// SALVA tessera
	public static void saveTessera (Tessera u) {
		
	t.begin();
	em.persist(u);
	t.commit();
	System.out.println("Tessera aggiunto al data base");

		
	}
	
	//CERCA TEssera
	public static Tessera cercaTessera(Integer id_tessera) {
			t.begin();
		Tessera u=	em.find(Tessera.class, id_tessera);
		t.commit();
		System.out.println("Tessera ricercato secondo id: "+id_tessera);
		return u;
	
}
	
// ELIMINA BY ID tessera
public static void deletaTessera(Integer id) {
	
	Tessera tes= cercaTessera(id);
    t.begin();
    em.remove(tes);
    t.commit();
    System.out.println("Tessera eliminato");
}
	
	// MODIFICA tesera
public static void modificaTessera(Tessera u) {
	
	t.begin();
    em.merge(u);
    t.commit();
	
	System.out.println("Tessera modificato");
	
}


public static void creaTesseract(Utente u) {
	Tessera tess = new Tessera();
	saveTessera(tess);
	Tessera tessPresa = cercaTessera(tess.getNumero_tessera());
	u.setTessera(tessPresa);
	UtenteDAO.modificaUtente(u);
	modificaTessera(tessPresa);
	System.out.println("Tessera creata per utente: "+u.getNome()+ " "+u.getCognome());
	

	
}
	
	
}
