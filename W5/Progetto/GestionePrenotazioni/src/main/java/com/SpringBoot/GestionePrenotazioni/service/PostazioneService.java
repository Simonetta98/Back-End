package com.SpringBoot.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.GestionePrenotazioni.model.Postazione;
import com.SpringBoot.GestionePrenotazioni.model.Tipo;
import com.SpringBoot.GestionePrenotazioni.repository.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	PostazioneRepository repo;
	
	public void savePostazione(Postazione p) {
		repo.save(p);
	}
	
	public Postazione getPostazioneByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updatePostazione(Postazione p) {
		repo.save(p);
	}
	
	public void removePostazione(Postazione p) {
		repo.delete(p);
	}
	
	public List<Postazione> getAllPostazione() {
		return (List<Postazione>) repo.findAll();
	}
	public List<Postazione> getPostazioneByTipo(Tipo tipo){
		return repo.findPostazioneByTipo(tipo);
	}
}
