package java_epi;

import java.util.ArrayList;

public class Carrello {
	ArrayList<Articolo> item;

	String cliente;
	String[] articoli;
	double totArticoli;
	
	public Carrello (ArrayList<Articolo> item ,String cliente, String[] articoli, double totArticoli) {
		this.item = new ArrayList<Articolo>();
		this.cliente = cliente;
		this.articoli = articoli;
		this.totArticoli = totArticoli;
	}
	public void addToCart(Articolo item) {
		this.item.add(item); //arrList method
	}
	
	public void stampaCarrello() {
		System.out.println("Cliente: " + this.cliente);
		System.out.println("Articoli nel carrello: " + java.util.Arrays.toString(this.articoli));
		System.out.println("Totale: " + this.totArticoli + "€");
	}

}
