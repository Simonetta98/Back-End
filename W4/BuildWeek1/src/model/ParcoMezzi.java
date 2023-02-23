package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import dao.BigliettoDAO;
import dao.ParcoMezziDAO;
import dao.TrattaDAO;
import dao.UtenteDAO;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class ParcoMezzi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_mezzo;
	@Column(nullable=false)
	private boolean inServizio=true;
	@Column
	private LocalDate dataInizioManutenzione;
	@Column
	private LocalDate dataFineManutenzione;
	@Column
	private Integer counter_biglietti=0;
	@Column
	private Integer counter_tappa=0;
	@OneToOne(mappedBy = "mezzo")
	private Tratta tratta;
	
	// il constructor nelle entita va sempre vuoto!!!
	public ParcoMezzi() {
		super();
	}
	
public void tempoEffettivo() {
	Tratta t= this.getTratta();
	System.out.println("Per andare da " + t.getPartenza() + " a " + t.getArrivo() + " questo mezzo impiega " + t.getDurataMediaTrattainMinuti() + " min");
	System.out.println("Per andare da " + t.getPartenza() + " a " + t.getArrivo() + " e tornare questo mezzo impiega " + t.getDurataMediaTrattainMinuti()*2 + " min");
	System.out.println("Questo mezzo ha viaggiato per " + (t.getDurataMediaTrattainMinuti()*this.getCounter_tappa()) + " min");
}
	
public void vidimaBigl(Utente u) {
		
		Set<Biglietto> listB = u.getListaBiglietti();
		List<Biglietto> listBigliettiValidi = listB.stream().filter(el->
		el.isValidita_biglietto() == true
				).collect(Collectors.toList());
		Biglietto biglietto = listBigliettiValidi.get(0);
		biglietto.setValidita_biglietto(false);
		biglietto.setData_vidima(LocalDate.now());
		this.counterPlus();
		BigliettoDAO.modificaBiglietto(biglietto);
		UtenteDAO.modificaUtente(u);
		
	}

public void counterPlus() {
	this.counter_biglietti++;
}
public void counterTappa() {
	this.counter_tappa++;
}
public void corri(Tratta tratta) {
	this.setTratta(tratta);
	tratta.setMezzo(ParcoMezziDAO.cercaMezzo(this.id_mezzo));
	TrattaDAO.modificaTratta(tratta);
	this.counterTappa();
	ParcoMezziDAO.modificaMezzo(ParcoMezziDAO.cercaMezzo(this.id_mezzo));
}

//////////////////////////////////////////
	public boolean isInServizio() {
		return inServizio;
	}
	

	public Integer getCounter_tappa() {
		return counter_tappa;
	}

	public void setCounter_tappa(Integer counter_tappa) {
		this.counter_tappa = counter_tappa;
	}

	public Integer getCounter_biglietti() {
		return counter_biglietti;
	}

	public void setCounter_biglietti(Integer counter_biglietti) {
		this.counter_biglietti = counter_biglietti;
	}

	public Integer getId_mezzo() {
		return id_mezzo;
	}

	public void setInServizio(boolean inServizio) {
		this.inServizio = inServizio;
	}

	public LocalDate getDataInizioManutenzione() {
		return dataInizioManutenzione;
	}

	public void setDataInizioManutenzione(LocalDate dataInizioManutenzione) {
		this.dataInizioManutenzione = dataInizioManutenzione;
	}

	public LocalDate getDataFineManutenzione() {
		return dataFineManutenzione;
	}

	public void setDataFineManutenzione(LocalDate dataFineManutenzione) {
		this.dataFineManutenzione = dataFineManutenzione;
	}

	

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	@Override
	public String toString() {
		return "ParcoMezzi [id_mezzo=" + id_mezzo + ", inServizio=" + inServizio + ", dataInizioManutenzione="
				+ dataInizioManutenzione + ", dataFineManutenzione=" + dataFineManutenzione + ", "
				+ ", tratta=" + tratta + "]";
	}
	

	
	
}
