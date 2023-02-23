package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import enums.DurataAbb;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PuntoEmissione implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_emissione;
	@OneToMany(mappedBy = "puntoEmissione")
	private Set<Abbonamento> abbonamenti;
	@Column
	private Integer counter_biglietti=0;
	@Column
	private Integer counter_abbonamenti=0;

	public PuntoEmissione() {
		super();
	}

	public Integer getCounter_biglietti() {
		return counter_biglietti;
	}

	public void setCounter_biglietti(Integer counter_biglietti) {
		this.counter_biglietti = counter_biglietti;
	}

	public Integer getCounter_abbonamenti() {
		return counter_abbonamenti;
	}

	public void setCounter_abbonamenti(Integer counter_abbonamenti) {
		this.counter_abbonamenti = counter_abbonamenti;
	}

	
	public Set<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }
    public void setAbbonamenti(Set<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }
	
    
    
	public Integer getId_emissione() {
		return id_emissione;
	}

	public void setId_emissione(Integer id_emissione) {
		this.id_emissione = id_emissione;
	}

	public void setCounterPlus() {
		this.counter_biglietti++;
	}


	// settare un abbonamento
	public void setAbbonamentiCompleto(Abbonamento abbonamento,Tessera tessera) {
		System.out.println("funzione va");
		tessera.setAbbonamento(abbonamento);
		System.out.println("tessera settata");
		this.counter_abbonamenti++;
		System.out.println("devi andare porca msieria");
		Set<Abbonamento> listaAbbonamenti = new HashSet<Abbonamento>();
		listaAbbonamenti.add(abbonamento);
		System.out.println("elemento pushato nella lsita");
		this.setAbbonamenti(listaAbbonamenti);
		
		
	}
	
}
