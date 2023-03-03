package com.SpringBoot.GestionePrenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBoot.GestionePrenotazioni.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

	@Query("SELECT e FROM Edificio e WHERE e.citta = ?1")
	public List<Edificio> findEdificioByCitta(String citta);

}
