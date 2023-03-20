package com.GestioneIncendi.processoControllo;

import java.util.HashSet;
import java.util.Set;

import com.GestioneIncendi.sonda.SondaDto;

import lombok.Getter;

@Getter
public class ProcessoDiControlloListener implements EventListener {
	static MessageFactory factory = new MessageFactory();
	private Set<SondaDto> sonde = new HashSet<SondaDto>();
	private String message;

	@Override
	public void update(String eventType, SondaDto data) {
		sonde.add(data);
		System.out.println("RECEIVING DATA FROM: \n" + data);
	    String mess = factory.getMessage(data.getSmokeLevel()).sendMessage();
	    message = mess;
	    System.out.println(mess);
	}

}
