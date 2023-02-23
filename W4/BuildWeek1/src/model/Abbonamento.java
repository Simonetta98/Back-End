package model;

import java.time.LocalDate;
import java.util.Set;
import java.util.Date;

import javax.persistence.*;

import enums.DurataAbb;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Abbonamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codice_univoco;
	@Column(nullable=false)
	private LocalDate data_emissione=LocalDate.now();
	@Column
	private LocalDate data_scadenza;
	@Enumerated(EnumType.STRING)
	private DurataAbb durata;
	@Column(nullable=false)
	private boolean validita_abbonamento=true;
	@OneToOne(mappedBy = "abbonamento")
	private Tessera tessera;
	@ManyToOne
	@JoinColumn(name = "id_emissione")
	private PuntoEmissione puntoEmissione;
	
	public Abbonamento() {
		super();
		// TODO Auto-generated constructor stub
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

	public LocalDate getData_scadenza() {
		return data_scadenza;
	}
	
//METODINO PER SETTARE SCADENZA ABBONAMENTINO
	public void setData_scadenza(LocalDate data_emissione) {
		if(this.durata==DurataAbb.MENSILE) {
		this.data_scadenza=data_emissione.plusMonths(1);
		} else if(this.durata==DurataAbb.SETTIMANALE) {
			this.data_scadenza=data_emissione.plusWeeks(1);		}
		
		
	}
	
	
//METODINO PER SETTARE VALIDITA DELL'ABBONAMENTO(DA PROVARE)
		public void setValidita(LocalDate emi,LocalDate scad) {
			if(emi.isAfter(scad)) {
				this.validita_abbonamento=false;
			}
		}


	public DurataAbb getDurata() {
		return durata;
	}

	public void setDurata(DurataAbb durata) {
		this.durata = durata;
	}

	public boolean isValidita() {
		return validita_abbonamento;
	}
	
	

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}


	public boolean isValidita_abbonamento() {
		return validita_abbonamento;
	}

	public void setValidita_abbonamento(boolean validita_abbonamento) {
		this.validita_abbonamento = validita_abbonamento;
	}

	public PuntoEmissione getPuntoEmissione() {
		return puntoEmissione;
	}

	public void setPuntoEmissione(PuntoEmissione puntoEmissione) {
		this.puntoEmissione = puntoEmissione;
	}

	
	
	@Override
	public String toString() {
		return "Abbonamento [codice_univoco=" + codice_univoco + ", data_emissione=" + data_emissione
				+ ", data_scadenza=" + data_scadenza + ", durata=" + durata + ", validita_abbonamento="
				+ validita_abbonamento + ", puntoEmissione=" + puntoEmissione + "]";
	}
	
}
