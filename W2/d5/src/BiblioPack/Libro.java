package BiblioPack;

import java.time.LocalDate;

public class Libro extends ElementoCatalogo {
	
	private String autore;
	private String genere;

	public Libro(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, String genere) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		// TODO Auto-generated constructor stub
		this.autore = autore;
		this.genere = genere;
	}
	
	//GETTERS_SETTERS
	

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	
	@Override
	public String toString() {
		return "ISBN: " + getIsbn() + ", " + "Titolo: " + getTitolo() + ", " + "genere: " + getGenere() + ", "
				+ "Autore: " + getAutore() +  ", "	+ "Anno di Pubblicazione: " + getAnnoPubblicazione() + ", " + "N. Pagine: " + getNumeroPagine()+ "#";
	}

}
