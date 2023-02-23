package model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import enums.DurataAbb;
import net.bytebuddy.asm.Advice.Local;

@Entity
public class Biglietto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codice_univoco;
	@Column(nullable=false)
	private LocalDate data_emissione;
	@Column(nullable=false)
	private boolean validita_biglietto=true;
	@ManyToOne
	@JoinColumn(name="utente_id")
	private Utente utente;
	@Column
	private LocalDate data_vidima;
	
	
	public Biglietto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LocalDate getData_vidima() {
		return data_vidima;
	}

	public void setData_vidima(LocalDate data_vidima) {
		this.data_vidima = data_vidima;
	}

	public Integer getCodice_univoco() {
		return codice_univoco;
	}
	public void setCodice_univoco(Integer codice_univoco) {
		this.codice_univoco = codice_univoco;
	}
	public LocalDate getData_emissione() {
		return data_emissione;
	}
	public void setData_emissione(LocalDate data_emissione) {
		this.data_emissione = data_emissione;
	}
	public boolean isValidita_biglietto() {
		return validita_biglietto;
	}
	public void setValidita_biglietto(boolean validita_biglietto) {
		this.validita_biglietto = validita_biglietto;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	@Override
	public String toString() {
		return "Biglietto [codice_univoco=" + codice_univoco + ", data_emissione=" + data_emissione
				+ ", validita_biglietto=" + validita_biglietto + ", data_vidima=" + data_vidima
				+ "]";
	}
	

}
