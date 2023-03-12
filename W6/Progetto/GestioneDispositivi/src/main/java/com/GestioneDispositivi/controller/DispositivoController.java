package com.GestioneDispositivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneDispositivi.entity.Dispositivo;
import com.GestioneDispositivi.entity.StatoDispositivo;
import com.GestioneDispositivi.entity.User;
import com.GestioneDispositivi.service.DispositivoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {
	
	@Autowired DispositivoService dService;
	
	//Vedi tutti i dispositivi
	@GetMapping
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Dispositivo> getDispositivi() {
		 return dService.getAllDispositivi();
	}
	
	//Trova un dispositivo
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Dispositivo> getDispositivo(@PathVariable Long id) {
		return new ResponseEntity<Dispositivo>(dService.getDispositivoById(id), HttpStatus.FOUND);
	}
	//Solo admin o moderatore possono creare/salvare dispositivi
	//NB--> per creare un dispositivo basta solo assegnare la proprietà tipo ->(ENUM TipologiaDispositivo)
	//(si può scegliere tra SMARTPHONE, TABLET, LAPTOP, IPAD, COMPUTER)
	//se già esistente in DB non lo ricrea
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo d) {
		return new ResponseEntity<Dispositivo>(dService.createDispositivo(d), HttpStatus.OK);
	}
	
	//Solo admin può assegnare dispositivi
	//il body è un oggetto User (al quale assegnare il dispositivo)
	//l'id corrisponde all'id del dispositivo che si vuole assegnare
	@PutMapping("/assign/{id}")    
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Dispositivo> adminAssignDispositivo(@RequestBody User user, @PathVariable Long id) {
		Dispositivo d = dService.getDispositivoById(id);
		d.getUsers().add(user);
		d.setStato(StatoDispositivo.ASSEGNATO);
		return new ResponseEntity<Dispositivo>(dService.updateDispositivo(d), HttpStatus.OK);
	}

	//Vedi tutti gli utenti che hanno dispositivi 
	@GetMapping("/assigned")
	@PreAuthorize("isAuthenticated()")
	public List<User> getDispositiviAssigned() {
		return dService.getAllUsersWithDispositivi();
	}
	
	//Manda il dispositivo di uno user in manutenzione
	//il body è l'oggetto dispositivo
	//l'id corrisponde all'id dello user
	//una volta in manutenzione lo user a cui apperteneva il disp non appare più nella lista users del dispositivo
	@PutMapping("/maintenance/for/{id}")    
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Dispositivo> modifyDispositivo(@RequestBody Dispositivo d, @PathVariable Long id){
		if(d.getStato() == StatoDispositivo.IN_MANUTENZIONE) {
			d.getUsers().removeIf(u -> u.getId() == id);
		}
		return new ResponseEntity<Dispositivo>(dService.updateDispositivo(d), HttpStatus.OK);
	}
	
	//Elimina un dispositivo
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> removeDispositivo(@PathVariable Long id) {
		return new ResponseEntity<String>(dService.removeDispositivo(id), HttpStatus.OK);
	}
	
	
}
