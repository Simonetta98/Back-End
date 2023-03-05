package com.SpringBoot.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.GestionePrenotazioni.model.Prenotazione;
import com.SpringBoot.GestionePrenotazioni.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository repo;
	
	public void savePrenotazione(Prenotazione p) {
		repo.save(p);
	}
	
	public Prenotazione getPrenotazioneByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updatePrenotazione(Prenotazione p) {
		repo.save(p);
	}
	
	public void removePrenotazione(Prenotazione p) {
		repo.delete(p);
	}
	
	public List<Prenotazione> getAllPrenotazione() {
		return (List<Prenotazione>) repo.findAll();
	}
	
	public void printInfo(Long id) {
		Prenotazione p = repo.findById(id).get();
		System.out.println("INFO PRENOTAZIONE: \n" + "ID: "+ p.getId_prenotazione() 
		+ "\n" + "PER " + p.getUtente().getNome_completo() + "\n" + "POSTAZIONE PRENOTATA" + p.getPostazione()
		+ "\n" + "DATA PRENOTAZIONE" + p.getDataPrenotazione()
		);
	}
}
