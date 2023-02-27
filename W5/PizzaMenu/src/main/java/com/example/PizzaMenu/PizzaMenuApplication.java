package com.example.PizzaMenu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configBeans.ConfigProducts;
import configBeans.Ingredienti;
import configBeans.Pizza;

@SpringBootApplication
public class PizzaMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaMenuApplication.class, args);
		
		configWith_Beans();
	}

	public static void configWith_Beans() {
		
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ConfigProducts.class); //nome della classe di configurazione
	   
		//recupero bean
		Pizza pizza = (Pizza) appCtx.getBean("createPizza", "Margherita", 6.50);
		System.out.println(pizza.infoProduct());
		//aggiungo un extra
		//se agg ingredienti specifici cambia nome
		//NORMA, CAPRICCIOSA, DIAVOLA...
		List<Ingredienti> list = new ArrayList<Ingredienti>();
		list.add(Ingredienti.MELANZANE_FRITTE);
		list.add(Ingredienti.RICOTTA_SALATA);
		Pizza pizzaWithExtra = (Pizza) appCtx.getBean("addExtra", pizza, list);
		System.out.println(pizzaWithExtra.infoProduct());
		
		((AnnotationConfigApplicationContext) appCtx).close();
		
	}
}
