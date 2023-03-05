package com.SpringBoot.GestionePrenotazioni.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prenotazione;
	private LocalDate dataPrenotazione;
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;
	@ManyToOne
	@JoinColumn(name = "codice_univoco")
	private Postazione postazione;
	
}
