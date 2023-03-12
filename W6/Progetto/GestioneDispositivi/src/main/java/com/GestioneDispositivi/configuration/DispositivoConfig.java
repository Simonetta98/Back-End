package com.GestioneDispositivi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestioneDispositivi.entity.Dispositivo;
import com.GestioneDispositivi.entity.TipologiaDispositivo;

@Configuration
public class DispositivoConfig {

	@Bean
	@Scope("prototype")
	public Dispositivo newDispositivo(TipologiaDispositivo tipo) {
		Dispositivo d = new Dispositivo();
		d.setTipo(tipo);
		
		return d;
	}
}
