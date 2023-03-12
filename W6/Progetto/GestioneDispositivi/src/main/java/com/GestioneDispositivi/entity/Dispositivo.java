package com.GestioneDispositivi.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dispositivi")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dispositivo;
	@Enumerated(EnumType.STRING)
	private TipologiaDispositivo tipo;
	@Enumerated(EnumType.STRING)
	private StatoDispositivo stato = StatoDispositivo.DISPONIBILE;
	
	  @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "users_devices",
	            joinColumns = @JoinColumn(name = "id_dispositivo", referencedColumnName = "id_dispositivo"),
	            inverseJoinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user")
	    )
	    private Set<User> users = new HashSet<>();
}
