package com.SpringBoot.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.GestionePrenotazioni.model.Edificio;
import com.SpringBoot.GestionePrenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	EdificioRepository repo;
	
	public void saveEdificio(Edificio e) {
		repo.save(e);
	}
	
	public Edificio getEdificioByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updateEdificio(Edificio e) {
		repo.save(e);
	}
	
	public void removeEdificio(Edificio e) {
		repo.delete(e);
	}
	
	public List<Edificio> getAllEdificio() {
		return (List<Edificio>) repo.findAll();
	}
	
	public List<Edificio> getEdificioByCitta(String citta){
		return repo.findEdificioByCitta(citta);
	}
	
}
	


