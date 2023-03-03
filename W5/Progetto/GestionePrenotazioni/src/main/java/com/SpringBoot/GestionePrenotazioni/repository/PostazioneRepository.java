package com.SpringBoot.GestionePrenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBoot.GestionePrenotazioni.model.Postazione;
import com.SpringBoot.GestionePrenotazioni.model.Tipo;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

     @Query("SELECT p FROM Postazione p WHERE p.tipo = ?1")
	 public List<Postazione> findPostazioneByTipo(Tipo tipo);
}
