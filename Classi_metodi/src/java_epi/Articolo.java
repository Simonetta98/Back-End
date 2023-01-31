package java_epi;

public class Articolo {
	String codice;
	String descrizione;
	double prezzo;
	int inMagazzino;
	
	static int totArticoli = 0;
	
	//constructor
	public Articolo(String codice, String descrizione, double prezzo, int inMagazzino) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.inMagazzino = inMagazzino;
		totArticoli++;
	}
	
	public void stampaArticolo() {
		System.out.println("Codice articolo: " + this.codice);
		System.out.println("Descrizione:" + this.descrizione);
		System.out.println("Prezzo: " + this.prezzo);
		System.out.println("Pezzi disponibili in magazzino: " + this.inMagazzino);
	}

}
