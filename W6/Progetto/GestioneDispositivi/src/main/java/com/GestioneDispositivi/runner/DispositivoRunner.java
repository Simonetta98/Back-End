package com.GestioneDispositivi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestioneDispositivi.configuration.DispositivoConfig;
import com.GestioneDispositivi.entity.Dispositivo;
import com.GestioneDispositivi.entity.TipologiaDispositivo;
import com.GestioneDispositivi.service.DispositivoService;

@Component
public class DispositivoRunner implements ApplicationRunner {

	@Autowired DispositivoConfig dConfig;
	@Autowired DispositivoService dService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("DispositivoIsRunning...");
		
		//Dispositivo laptop = dConfig.newDispositivo(TipologiaDispositivo.LAPTOP);
		//Dispositivo smartphone = dConfig.newDispositivo(TipologiaDispositivo.SMARTPHONE);
		//Dispositivo tablet = dConfig.newDispositivo(TipologiaDispositivo.TABLET);
		
        //aggiungi in DB		
		//dService.createDispositivo(laptop);
		//dService.createDispositivo(smartphone);
		//dService.createDispositivo(tablet);
		
		
		//ASSEGNAZIONE & GESTIONE DEI DISPOSITIVI --> in DispositivoController --> testato tramite POSTMAN
		
	}
	

}
