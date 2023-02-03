package PlayerPack;

import java.util.Scanner;

public class MainProjetct {
	
	static Scanner sc = new Scanner(System.in);
	static ElementoMultimediale[] el = new ElementoMultimediale[5];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		System.out.println("Ciao! Questo è un Lettore Multimediale.");
		System.out.println("Puoi registrare 5 Elementi Multimediali di tipo Immagine/Audio/Video");
		System.out.println("------------------------------------------");
		
//1 -		
//scelta e creazione del tipo di file (audio, video, img) che finisce nell'arr[] el -----------------------------
	
		for(int i=0; i<el.length; i++) {
			
			System.out.println((i+1) + "/" + (el.length) + " - Seleziona che tipo di file vuoi creare:" + " 1)Immagine, 2)Video, 3)Audio");
			int tipo = sc.nextInt();
		
			switch (tipo) {
			
			case 1:
				System.out.println("NB: non puoi proseguire se un campo viene lasciato vuoto");
				System.out.println("------------------------------------------");
				//TITOLO
				System.out.println("Titolo immagine: ");
				String titolo = sc.nextLine();
				
				 while (titolo == "") {   //CONTROLLO
					 
			        	titolo = sc.nextLine();
			        	
			        }
				 
				//LUMINOSITA'
				 int luminosita;
					do {
					    System.out.println("Luminosità immagine:");
					    
					    while (!sc.hasNextInt()) {                  //CONTROLLO
					    	
					        System.out.println("Devi inserire un numero!");  
					        sc.next(); // 
					    }
					    
					    luminosita = sc.nextInt();
					    
					} while (luminosita <= 0);         //CONTROLLO
					

				el[i] = new Immagine(titolo, luminosita);
				el[i].isImage = 1;
				break;
				
			case 2:
				
				//TITOLO
				System.out.println("Titolo video: ");
				String titolo1 = sc.nextLine();
				
				 while (titolo1 == "") {   //CONTROLLO
					 
			        	titolo1 = sc.nextLine();
			        	
			        }
				
				//DURATA
				 int durata1;
					do {
					    System.out.println("Durata video:");
					    
					    while (!sc.hasNextInt()) {                  //CONTROLLO
					    	
					        System.out.println("Devi inserire un numero!");  
					        sc.next(); // 
					    }
					    
					    durata1 = sc.nextInt();
					    
					} while (durata1 <= 0);    //
				
				//VOLUME
				 int volume1;
					do {
					    System.out.println("Volume video:");
					    
					    while (!sc.hasNextInt()) {                  //CONTROLLO
					    	
					        System.out.println("Devi inserire un numero!");  
					        sc.next(); // 
					    }
					    
					    volume1 = sc.nextInt();
					    
					} while (volume1 <= 0);     //
				
				//LUMINOSITA'
				 int luminosita1;
					do {
					    System.out.println("Luminosità video:");
					    
					    while (!sc.hasNextInt()) {                  //CONTROLLO
					    	
					        System.out.println("Devi inserire un numero!");  
					        sc.next(); // 
					    }
					    
					    luminosita1 = sc.nextInt();
					    
					} while (luminosita1 <= 0);     //
					
					

				el[i] = new Video(titolo1, durata1, luminosita1, volume1);
				el[i].isImage = 0;
				break;
				
			case 3:
				
				//TITOLO
				System.out.println("Titolo audio: ");
				String titolo2 = sc.nextLine();
				
				 while (titolo2 == "") {   //CONTROLLO
					 
			        	titolo2 = sc.nextLine();
			        	
			        }

				//DURATA
				 int durata2;
					do {
					    System.out.println("Durata video:");
					    
					    while (!sc.hasNextInt()) {                  //CONTROLLO
					    	
					        System.out.println("Devi inserire un numero!");  
					        sc.next(); // 
					    }
					    
					    durata2 = sc.nextInt();
					    
					} while (durata2 <= 0);

					//VOLUME
					 int volume2;
						do {
						    System.out.println("Volume video:");
						    
						    while (!sc.hasNextInt()) {                  //CONTROLLO
						    	
						        System.out.println("Devi inserire un numero!");  
						        sc.next(); // 
						    }
						    
						    volume2 = sc.nextInt();
						    
						} while (volume2 <= 0);

				el[i] =new Audio(titolo2, durata2, volume2);
				el[i].isImage = 0;
				break;

			}

		}
		System.out.println("Player pieno: hai creato " + (el.length) + " file multimediali");
		leggiEl();
		}
	
   //2 -
   //seleziona uno dei file creati e mostralo ------------------------------------------------------
		
		public static void leggiEl() {
	        
	        System.out.println("------ PLAYLIST ------");
	        System.out.println("Per vedere/ascoltare un file digita il numero corrispondente (1-5)");
	        System.out.println("Se vuoi spegnere il lettore digita 0");
	       
	        int index = sc.nextInt() - 1;

	        if ( index >= 0 && index <= 4 ) {
	        	if ( el[index] instanceof Audio ) {     //se è di tipo audio||video allora play()
	        		Audio audio = (Audio) el[index];
	        		audio.play();
	        		
	        	} else if ( el[index] instanceof Video ) {
	        		Video video = (Video) el[index];
	        		video.play();
	        		
	        	} else {                            //se è di tipo imagine allora show()
	        		Immagine video = (Immagine) el[index];
	        		video.show();
	        	}
	        	
	        	System.out.println("----------------------");
	        	leggiEl();
	        	
	        } else if ( index == -1) {
	        	System.out.println("Hai spento il lettore.");
	        	sc.close();
       		  
       		} else {
	        	System.out.println("Questo file non esiste, digita un altro numero:");
	        	leggiEl();
	        }
	        

		/*

       */
			
		
		
	}

}
