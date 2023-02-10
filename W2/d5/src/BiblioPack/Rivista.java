package BiblioPack;

import java.time.LocalDate;

public class Rivista extends ElementoCatalogo {
	
	private Periodicita periodicita;

	public Rivista(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		// TODO Auto-generated constructor stub
		this.periodicita = periodicita;
	}
	
	//GETTERS_SETTERS
	
	public Periodicita getPeriodicita() {
		return periodicita;
	}
	
	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	
	@Override
	public String toString() {
		return "ISBN: " + getIsbn() + ", " + "Titolo: " + this.getTitolo() + ", " + "Anno di pubblicazione: "
				+ this.getAnnoPubblicazione() + ", " + "N.Pagine: " + this.getNumeroPagine() + ", "
				+ "Periodicità: " + periodicita + "#";
	}

}
