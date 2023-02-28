package com.GodfathersPizza.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.GodfathersPizza.model.BrandMug;
import com.GodfathersPizza.model.BrandShirt;
import com.GodfathersPizza.model.Lemonade;
import com.GodfathersPizza.model.Menu;
import com.GodfathersPizza.model.Pizza;
import com.GodfathersPizza.model.PizzaFamilySize;
import com.GodfathersPizza.model.PizzaHawaiian;
import com.GodfathersPizza.model.PizzaMargherita;
import com.GodfathersPizza.model.PizzaSalami;
import com.GodfathersPizza.model.ToppingCheese;
import com.GodfathersPizza.model.ToppingHam;
import com.GodfathersPizza.model.ToppingOnions;
import com.GodfathersPizza.model.Water;
import com.GodfathersPizza.model.Wine;

@Configuration
public class MenuConfiguration {

	@Bean
	public Menu menu() {
		Menu menu = new Menu();
		
		
		//Creare un Bean di tipo PizzaMargherita
		//List<Pizza> listaPizze = menu.getMenuPizza();
		//PizzaMargherita pm = pizzaMargherita();
		//listaPizze.add(pm);
		menu.getMenuPizza().add(pizzaMargherita());
		
		//Creare un Bean di tipo PizzaHawaiian
		menu.getMenuPizza().add(pizzaHawaiian());
		
		//Creare un Bean di tipo PizzaSalami
		menu.getMenuPizza().add(pizzaSalami());
		
		//Creare un Bean di tipo PizzaFamilySize
		menu.getMenuPizza().add(pizzaFamilySize());
		
		//Creare un Bean di tipo Lemonade
		menu.getMenuDrink().add(lemonade());
		
		//Creare un Bean di tipo Water
		menu.getMenuDrink().add(water());
		
		//Creare un Bean di tipo Wine
		menu.getMenuDrink().add(wine());
		
		//Creare un Bean di tipo ToppingCheese
		menu.getMenuTopping().add(toppingCheese());
		
		//Creare un Bean di tipo ToppingHam
		menu.getMenuTopping().add(toppingHam());
		
		//Creare un Bean di tipo ToppingOnions
		menu.getMenuTopping().add(toppingOnions());
		
		//Creare un Bean di tipo BrandShirt
		menu.getMenuBrand().add(brandShirt());
		
		//Creare un Bean di tipo BrandMug
		menu.getMenuBrand().add(brandMug());
		
		return menu;
	}
	
	@Bean
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}
	
	@Bean
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}
	
	@Bean
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}
	
	@Bean
	public PizzaFamilySize pizzaFamilySize() {
		return new PizzaFamilySize(null);
	}
	
	@Bean
	public Lemonade lemonade() {
		return new Lemonade();
	}
	
	@Bean
	public Water water() {
		return new Water();
	}
	
	@Bean
	public Wine wine() {
		return new Wine();
	}
	
	@Bean
	public ToppingCheese toppingCheese() {
		return new ToppingCheese(null);
	}
	
	@Bean
	public ToppingHam toppingHam() {
		return new ToppingHam(null);
	}
	
	@Bean
	public ToppingOnions toppingOnions() {
		return new ToppingOnions(null);
	}
	
	@Bean
	public BrandShirt brandShirt() {
		return new BrandShirt();
	}
	
	@Bean
	public BrandMug brandMug() {
		return new BrandMug();
	}
	
}
