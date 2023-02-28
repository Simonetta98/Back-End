package com.GodfathersPizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.GodfathersPizza.configuration.MenuConfiguration;
import com.GodfathersPizza.configuration.OrdersConfiguration;
import com.GodfathersPizza.model.Coperto;
import com.GodfathersPizza.model.Menu;
import com.GodfathersPizza.model.Ordine;
import com.GodfathersPizza.model.PostoVuoto;
import com.GodfathersPizza.model.Prodotto;
import com.GodfathersPizza.model.StatoOrdine;
import com.GodfathersPizza.model.Tavolo;


@SpringBootApplication
public class GodfathersPizzaApplication {
	
	static Menu menu;
	
	static List<Coperto> coperti = new ArrayList<Coperto>();
	static List<Tavolo> tavoli = new ArrayList<Tavolo>();
	static List<Ordine> ordini = new ArrayList<Ordine>();

	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizzaApplication.class, args);
		
		gestioneMenu();
		
		/////////////////parte 2
		
		gestioneOrdini();
		
		coperti.forEach(e-> System.out.println(e));
		tavoli.forEach(e-> System.out.println(e));
		ordini.forEach(e-> System.out.println(e));
		ordini.forEach(e-> System.out.println(e.calcolaTotale()));
		//System.out.println(tavoli.get(2));

	}
	
	public static void gestioneMenu() {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
	
		// Recupero Bean
		menu = (Menu) appCtx.getBean("menu");
		stampaMenu();
		
		appCtx.close();
	}
	
	public static void stampaMenu() {
		System.out.println("********** Menu **********");
		System.out.println("PIZZAS ------------------");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuPizza()));
		
		System.out.println("TOPPINGS ------------------");
		menu.getMenuTopping().forEach(t -> System.out.println(t.getMenuTopping()));
		
		System.out.println("DRINKS ------------------");
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuDrink()));
		
		System.out.println("FRANCHISE ------------------");
		menu.getMenuBrand().forEach(a -> System.out.println(a.getMenuArticoloBrand()));
	}
	
	////////////////parte 2 
	
	public static void gestioneOrdini() {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(OrdersConfiguration.class);
		
		//mi serve per il num max di posti dei tavoli
		Random rand = new Random();
		//tavoli con posti da min 2 a max 6
		int int_random = (int)Math.floor(Math.random() * (6 - 2 + 1) + 2);;
	
		
		for(int i=0; i<5; i++) {
			
			// Recupero Bean coperti
			Coperto coperto = (Coperto) appCtx.getBean("coperto");
			coperti.add(coperto);
			
			// Recupero Bean tavoli 
			//sono tavoli vuoti(senza coperti)
		    Tavolo tavolo = (Tavolo) appCtx.getBean("tavolo", int_random);
		    tavoli.add(tavolo);
		}
	
		 List<Prodotto> prodottiDaOrdinare = new ArrayList<Prodotto>();
		prodottiDaOrdinare.add(menu.getMenuPizza().get(1));
		prodottiDaOrdinare.add(menu.getMenuPizza().get(2));
		prodottiDaOrdinare.add(menu.getMenuDrink().get(1));
		
		//per dare un tavolo a un ordine devono esserci dei coperti
		//i coperti che posso aggiungere hanno un limite max dato dal tavolo
		Tavolo tavolo1 =  tavoli.get(1);
		Coperto[]arrCoperti = new Coperto[tavolo1.getNumeroCopertiMax()];
		
		//popolo array con un certo num di coperti(i)
		for(int i=0; i<=1; i++) { 
			arrCoperti[i] = coperti.get(i) ;
		}
		//se qualche posto rimane vuoto(null) diventa un PostoVuoto(prezzo 0)
		PostoVuoto postoVuoto = new PostoVuoto();
		
		for(int i=0; i<=arrCoperti.length-1; i++) { 
			if(arrCoperti[i]==null) {
				arrCoperti[i] = postoVuoto;
			}
		}
		
		tavolo1.setCoperti(arrCoperti);
		tavolo1.setStato();
		
		//System.out.println("TAVOLO PRINT PROVA" + tavolo1);
		
		// Recupero Bean ordini 
		Ordine ordine = (Ordine) appCtx.getBean("ordine", tavolo1, prodottiDaOrdinare, StatoOrdine.IN_CORSO, "le pizze ben cotte", tavolo1.getCoperti().length);
		//System.out.println(ordine);
		//System.out.println("TOTALE " + ordine.calcolaTotale());
		
		ordini.add(ordine);
		
		appCtx.close();
		//System.out.println(coperto2);
	}

}
