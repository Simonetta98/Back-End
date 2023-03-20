package com.GestioneIncendi.processoControllo;

public class Alarm implements Message {

	@Override
	public String sendMessage() {
		return "****************** ALARM STARTED *****************";
	}

}
