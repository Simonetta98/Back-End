package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Utente implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_utente;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="numero_tessera") // il join column va nell'ogetto principale
	private Tessera tessera;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	
	@OneToMany(mappedBy = "utente",cascade = CascadeType.ALL)
	private Set<Biglietto> listaBiglietti;
	
	public Integer getId_utente() {
		return id_utente;
	}
	public void setId_utente(Integer id_utente) {
		this.id_utente = id_utente;
	}
	public Tessera getTessera() {
		return tessera;
	}
	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setListBiglCompl(Biglietto biglietto) {
		Set<Biglietto> listaBig = new HashSet<Biglietto>();
		System.out.println("lista creata");
		listaBig.add(biglietto);
		System.out.println("biglietto agg");
		this.setListaBiglietti(listaBig);
		System.out.println("tutto fatto lista");
	}


	public Set<Biglietto> getListaBiglietti() {
		return listaBiglietti;
	}
	public void setListaBiglietti(Set<Biglietto> listaBiglietti) {
		this.listaBiglietti = listaBiglietti;
	}
	@Override
	public String toString() {
		return "Utente [id_utente=" + id_utente + ", tessera=" + tessera + ", nome=" + nome + ", cognome=" + cognome
				+ ", listaBiglietti=" + listaBiglietti + "]";
	}
}
