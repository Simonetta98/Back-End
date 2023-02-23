package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tessera implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer numero_tessera;
	@OneToOne(mappedBy = "tessera") // il mappedby va nell'oggetto che vogliamo sia secondario
	private Utente utente;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="codice_univoco")
	private Abbonamento abbonamento;
	@Column(nullable=false)
	private LocalDate data_emissione=LocalDate.now();
	
	@Column
	private LocalDate data_scadenza=this.data_emissione.plusYears(1);
	@Column(nullable=false)
	private boolean validita_tessera=true;
	
	
	
	public Tessera() {
		super();
	}


	public Integer getNumero_tessera() {
		return numero_tessera;
	}
	public void setNumero_tessera(Integer numero_tessera) {
		this.numero_tessera = numero_tessera;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Abbonamento getAbbonamento() {
		return abbonamento;
	}
	public void setAbbonamento(Abbonamento abbonamento) {
		this.abbonamento = abbonamento;
	}
	public LocalDate getData_emissione() {
		return data_emissione;
	}
	
	public LocalDate getData_scadenza() {
		return data_scadenza;
	}
	


	public boolean isValidita_tessera() {
		return validita_tessera;
	}


	public void setValidita_tessera(boolean validita_tessera) {
		this.validita_tessera = validita_tessera;
	}


	public void setData_emissione(LocalDate data_emissione) {
		this.data_emissione = data_emissione;
	}


	public void setData_scadenza(LocalDate data_scadenza) {
		this.data_scadenza = data_scadenza;
	}


	@Override
	public String toString() {
		return "Tessera [numero_tessera=" + numero_tessera + ", abbonamento=" + abbonamento + ", data_emissione="
				+ data_emissione + ", data_scadenza=" + data_scadenza + ", validita_tessera=" + validita_tessera + "]";
	}


	
}
