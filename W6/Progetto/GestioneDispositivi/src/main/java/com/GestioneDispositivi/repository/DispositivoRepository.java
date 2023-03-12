package com.GestioneDispositivi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestioneDispositivi.entity.Dispositivo;
import com.GestioneDispositivi.entity.TipologiaDispositivo;
import com.GestioneDispositivi.entity.User;


@Repository
public interface DispositivoRepository extends CrudRepository<Dispositivo, Long> {

	public boolean existsByTipo(TipologiaDispositivo tipo);
	
	@Query("SELECT e FROM Dispositivo e WHERE e.tipo = ?1")
	public Dispositivo findByTipo(TipologiaDispositivo tipo);
	
	@Query("SELECT users FROM Dispositivo")
	public List<User> findUsersByDevices();
}
