package com.GestioneIncendi.centroControllo;

import com.GestioneIncendi.processoControllo.ProcessoDiControlloListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CentroDiControlloProxy implements CentroDiControllo {

	private static CentroDiControllo cdc;
	private ProcessoDiControlloListener e;

	@Override
	public void loadData(long id) {
		if(cdc == null) {
			cdc = new CentroDiControlloImpl(e);
		}
		cdc.loadData(id);
		
	}
}
