package com.GestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestioneDispositivi.entity.User;
import com.GestioneDispositivi.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired UserRepository repo;
	
	public User getUserById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Questo Utente non esiste");
		}
		User u = repo.findById(id).get();
		return u;
	}
	
	public User updateUser(User d) {
		if(!repo.existsById(d.getId())) {
			throw new EntityNotFoundException("Questo Utente non esiste");
		}
		repo.save(d);
		return d;
	}
	
	public String removeUser(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Questo Utente non esiste");
		}
		repo.deleteById(id);
		return "Utente eliminato";
	}
	
	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
	}
	
}
