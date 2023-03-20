package com.GestioneIncendi.centroControllo;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.GestioneIncendi.processoControllo.ProcessoDiControlloListener;
import com.GestioneIncendi.sonda.SondaDto;

public class CentroDiControlloImpl implements CentroDiControllo {
	private ProcessoDiControlloListener processo;
	
    public CentroDiControlloImpl(ProcessoDiControlloListener e) {
	        initializingConnection(e);
	        processo = e;
	    }

	@Override
	public void loadData(long id) {
		SondaDto s = processo.getSonde().stream().filter(e->e.getIdSonda()==id).collect(toSingleton());
		 System.out.println("LOADING DATA FROM: \n"
                 + "http://host/alarm=?"
                 + "idsonda="
                 + s.getIdSonda()
                 + "&lat="
                 + s.getLatitude()
                 + "&lon="
                 + s.getLongitude()
                 + "&smokelevel="
                 + s.getSmokeLevel()
                 );
		 System.out.println("DISPLAYING DATA: \n" + s);
		 System.out.println(processo.getMessage());
	}
	
	public static <T> Collector<T, ?, T> toSingleton() {
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                if (list.size() != 1) {
	                    throw new IllegalStateException();
	                }
	                return list.get(0);
	            }
	    );
	}
	
	public void initializingConnection(ProcessoDiControlloListener e) {
		System.out.println("Initializing connection...");
		for(int i=0; i<3; i++) {
			latency();
			System.out.println("...");
		}
		System.out.println("CONNECTED");
		latency();
	}
	public void latency() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
