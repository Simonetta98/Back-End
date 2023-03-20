package com.GestioneIncendi.processoControllo;

import com.GestioneIncendi.sonda.SondaDto;

public interface EventListener {

	public void update(String eventType, SondaDto data);
}
