package com.SpringBoot.GestionePrenotazioni.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_utente;
	private String username;
	private String nome_completo;
	@Column(unique = true)
	private String email;
	@OneToMany(mappedBy = "utente", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<Prenotazione> prenotazioni;
	@Override
	public String toString() {
		return "ID=" + id_utente + ", username=" + username + ", nome_completo=" + nome_completo
				+ ", email=" + email ;
	}
	
     public boolean checkDateUtente(String data) {
	    	return prenotazioni.stream()
	    			           .anyMatch(e->e.getDataPrenotazione().toString().matches(data));
	 }
	
}
