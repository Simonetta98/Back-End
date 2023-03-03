package com.SpringBoot.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.GestionePrenotazioni.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {


}
