package com.GestioneIncendi.processoControllo;

public class Info implements Message {

	@Override
	public String sendMessage() {
		return " ---- INFO ----" + "\n SMOKE LEVELS OK";
	}

}
