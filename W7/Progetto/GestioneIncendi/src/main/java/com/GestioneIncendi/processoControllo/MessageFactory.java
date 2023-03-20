package com.GestioneIncendi.processoControllo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MessageFactory {

	public Message getMessage(int smokeLevel) {
		 Message m = null;
		 
		if(smokeLevel > 2 && smokeLevel < 5) {
			m = new Warning();
		}else if(smokeLevel == 5) {
			m = new Alarm();
		}else {
			m = new Info();
		}
		return m;
	}
}
