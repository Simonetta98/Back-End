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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneDispositivi.entity.User;
import com.GestioneDispositivi.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired UserService uService;
	
	//il salvataggio avviene al signup

	   //Vedi tutti gli users
	   @GetMapping
	   @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	   public List<User> getUsers() {
		 return uService.getAllUsers();
	   }
	   //Trova uno user
	   @GetMapping("/search/{id}")
	   @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	   public ResponseEntity<User> getUser(@PathVariable Long id) {
			return new ResponseEntity<User>(uService.getUserById(id), HttpStatus.FOUND);
		}
	   
	   //Modifica dati user
	   @PutMapping("/modify")    
	   @PreAuthorize("isAuthenticated()")
		public ResponseEntity<User> modifyUser(@RequestBody User user) {
			return new ResponseEntity<User>(uService.updateUser(user), HttpStatus.OK);
		}
	
	   //Elimina uno user
		@DeleteMapping("/delete/{id}")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<String> removeUser(@PathVariable Long id) {
			return new ResponseEntity<String>(uService.removeUser(id), HttpStatus.OK);
		}
	
}
