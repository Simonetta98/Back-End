package com.SpringBoot.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.GestionePrenotazioni.model.Utente;
import com.SpringBoot.GestionePrenotazioni.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository repo;
	
	public void saveUtente(Utente u) {
		repo.save(u);
	}
	
	public Utente getUtenteByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updateUtente(Utente u) {
		repo.save(u);
	}
	
	public void removeUtente(Utente u) {
		repo.delete(u);
	}
	
	public List<Utente> getAllUtente() {
		return (List<Utente>) repo.findAll();
	}
	

}
