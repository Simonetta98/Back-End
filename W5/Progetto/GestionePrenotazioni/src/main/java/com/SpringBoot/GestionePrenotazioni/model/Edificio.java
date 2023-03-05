package com.SpringBoot.GestionePrenotazioni.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Edificio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_edificio;
	private String nome_edificio;
	private String indirizzo;
	private String citta;
	@OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) 
	private Set<Postazione> postazioni;
	
	@Override
	public String toString() {
		return "[ID= " + id_edificio + ", NOME= " + nome_edificio + ", INDIRIZZO= " + indirizzo
				+ ", CITTA= " + citta + "]";
	}
	
	
}
