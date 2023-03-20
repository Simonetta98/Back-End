package com.GestioneIncendi.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestioneIncendi.centroControllo.CentroDiControllo;
import com.GestioneIncendi.centroControllo.CentroDiControlloProxy;
import com.GestioneIncendi.processoControllo.ProcessoDiControlloListener;
import com.GestioneIncendi.sonda.Sonda;

@Component
public class GestioneIncendiRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("GestioneIncendi running...");
		
		ProcessoDiControlloListener pc1 = new ProcessoDiControlloListener();
		
		Sonda s1 = new Sonda();
		s1.setIdSonda(1);
		s1.setLatitude(32.83662);
		s1.setLongitude(7.37288);
		
		Sonda s2 = new Sonda();
		s2.setIdSonda(2);
		s2.setLatitude(41.26389);
		s2.setLongitude(57.46382);
		
		
		/* FACTORY pattern:
		 * Prevede la creazione di un'interfaccia o classe astratta
		 * che sarà comune a tutte le sottoclassi e 
		 * di una classe Factory che si occuperà di creare oggetti,
		 * ma la decisione del tipo di classe da istanziare
		 * viene lasciata alle sottoclassi.
		 * 
		 * In questo progetto le classi Alarm, Info e Warning implementano
		 * l'interfaccia Message e realizzano un override del metodo sendMessage().
		 * Il MessageFactory si occupa così di creare un messaggio diverso
		 * a seconda del livello di fumo percepito dalle sonde.
		 */
		
		//info: 1,2
		//warning: 3,4
		//alarm: 5
		s1.setSmokeLevel(1);
		s2.setSmokeLevel(3);
		
		/* OBSERVER pattern:
		 * Prevede un subject (o publisher) che attraverso
		 * un meccanismo di 'sottoscrizione' (subscribe)
		 * notificherà altri oggetti (subscribers/listeners) ad ogni suo cambiamento di stato,
		 * sfruttando la loro interfaccia comune.
		 * 
		 * In questo progetto i subjects sono le Sonde,
		 * il listener/subscriber, ovvero l'oggetto interessato allo stato di queste ultime,
		 * è il Processo di Controllo (che implementa l'interfaccia EventListener, dove all'interno
		 * si trova il metodo update(), che viene sfruttato dalle sonde per notificare/comunicare i loro cambiamenti di stato).
		 */
		
		// "emissione_di_dati" è il processo di emissione di dati della sonda a cui si sottoscrive pc1.
		s1.em.subscribe("emissione_di_dati", pc1);
		s2.em.subscribe("emissione_di_dati", pc1);
		
		//Così ad ogni cambiamento\emissione di dati, pc1 li riceve ...
	
		s1.dataEmission();
		s2.dataEmission();
		
		//... e li trasmette al Centro di Controllo ↓ 
		
		//PROXY pattern
		/* Quando vi è la presenza di oggetti 'pesanti', che possono richiedere un
		 * tempo o costo maggiore di inizializzazione, si ricorre al Proxy.
		 * Il Proxy inizializza un oggetto solo se strettamente richiesto(in questo caso il Centro di Controllo e la connessione al server).
		 * Invece di comunicare direttamente con il server, 
		 * il client comunica con l'oggetto Proxy che implementa l'interfaccia
		 * del server e ne fa da sostituto, potendone così controllare le richieste ed
		 * eventualmente implementare anche dei processi di sicurezza.
		 * 
		 * In questo progetto, ad esempio, l'inizializzazione di un Centro di Controllo e la conseguente connessione iniziale al server 
		 * avverrà una sola volta (come si può notare dall'output dei due metodi loadData() sotto).
		 * Dopo il primo loadData(), non verrà più istanziato un altro Centro di Controllo, che sarà ora memorizzato all'interno del Proxy,
		 * ma avverrà solo il caricamento dei dati richiesti.
		 */
		
		
		CentroDiControllo cdc = new CentroDiControlloProxy(pc1);
		//cdc.loadData(1);
		//cdc.loadData(2);

	}

}
