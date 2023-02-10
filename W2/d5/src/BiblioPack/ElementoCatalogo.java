package BiblioPack;

import java.time.LocalDate;

public class ElementoCatalogo {
	private String isbn;
	private String titolo;
	private LocalDate annoPubblicazione;
	private int numeroPagine;
	
	public ElementoCatalogo(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}
	
	//GETTERS_SETTERS
	
	public String getIsbn() {
		return isbn;
	}


	public String getTitolo() {
		return titolo;
	}

	
	public LocalDate getAnnoPubblicazione() {
		return annoPubblicazione;
	}


	public int getNumeroPagine() {
		return numeroPagine;
	}


	@Override
	public String toString() {
		return "ArticoloDiLettura [isbn=" + isbn + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	

}
