package com.GestioneIncendi.processoControllo;

public class Warning implements Message {

	@Override
	public String sendMessage() {
		return " ---- WARNING ----" + "\n HIGH SMOKE LEVELS";
	}

}
