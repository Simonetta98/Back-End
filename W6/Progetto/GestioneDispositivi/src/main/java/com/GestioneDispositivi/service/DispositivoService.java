package com.GestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestioneDispositivi.entity.Dispositivo;
import com.GestioneDispositivi.entity.TipologiaDispositivo;
import com.GestioneDispositivi.entity.User;
import com.GestioneDispositivi.repository.DispositivoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class DispositivoService {

	@Autowired DispositivoRepository repo;
	
	public Dispositivo createDispositivo(Dispositivo d) {
		if(repo.existsByTipo(d.getTipo())) {
			throw new EntityExistsException("Questa Tipologia di Dispositivo è già presente");
		}
		repo.save(d);
		return d;
	}
	
	public Dispositivo getDispositivoById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Questo Dispositivo non esiste");
		}
		Dispositivo u = repo.findById(id).get();
		return u;
	}
	
	public Dispositivo getDispositivoByTipo(TipologiaDispositivo tipo) {
		if(!repo.existsByTipo(tipo)) {
			throw new EntityNotFoundException("Questa Tipologia di Dispositivo non esiste");
		}
		Dispositivo u = repo.findByTipo(tipo);
		return u;
	}
	
	public Dispositivo updateDispositivo(Dispositivo d) {
		if(!repo.existsById(d.getId_dispositivo())) {
			throw new EntityNotFoundException("Questo Dispositivo non esiste");
		}
		repo.save(d);
		return d;
	}
	
	public String removeDispositivo(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Questo Dispositivo non esiste");
		}
		repo.deleteById(id);
		return "Dispositivo eliminato";
	}
	
	public List<Dispositivo> getAllDispositivi(){
		return (List<Dispositivo>) repo.findAll();
	}
	
	public List<User> getAllUsersWithDispositivi(){
		return (List<User>) repo.findUsersByDevices();
	}
}
