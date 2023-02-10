package BiblioPack;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainArchivio {
	
    private static int isbn = 6;
    
    static File fileArchivio = new File("archivio.txt");
    
    static Scanner sc = new Scanner(System.in);
	
	static Logger logger = LoggerFactory.getLogger(MainArchivio.class);
	
	static List<ElementoCatalogo> archivio = new ArrayList<ElementoCatalogo>();
	static List<Libro>listaLibri = new ArrayList<Libro>();
	static List<Rivista>listaRiviste = new ArrayList<Rivista>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creo un file dell'Archivio
		try {
			fileArchivio.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Aggiungo qualche elemento alle liste libri/riviste
		Libro libro0 = new Libro("000", "Il vecchio che leggeva romanzi d'amore", LocalDate.parse("1989-03-04"), 230, "Luis Sepúlveda", "Narrativa");
		Libro libro1 = new Libro("001", "Storia di una gabbianella e del gatto che le insegnò a volare", LocalDate.parse("1988-10-01"), 100, "Luis Sepúlveda", "Narrativa");
		Libro libro2 = new Libro("002", "Il maestro e Margherita", LocalDate.parse("1967-10-12"), 120, "Michail Afanas'evič Bulgakov", "Narrativa fantasy");
		
		Rivista riv1 = new Rivista("004", "Vogue", LocalDate.parse("1892-08-10"), 90, Periodicita.MENSILE);
		Rivista riv2 = new Rivista("005", "Art-attack", LocalDate.parse("2000-12-10"), 50, Periodicita.SETTIMANALE);
		Rivista riv3 = new Rivista("006", "Rivista dei gatti", LocalDate.parse("2020-11-05"), 80, Periodicita.SEMESTRALE);
		
		listaLibri.add(libro0);
		listaLibri.add(libro1);
		listaLibri.add(libro2);
		
		listaRiviste.add(riv1);
		listaRiviste.add(riv2);
		listaRiviste.add(riv3);
		
		//Archivio sarà una lista formata dall'unione di lista libri e lista riviste
		archivio = Stream.concat(listaLibri.stream(), listaRiviste.stream()).collect(Collectors.toList());
		System.out.println(archivio);
		
	
		
		//MENU
		int start = 1;
		
		do {
			System.out.printf("Premi un numero : %n" 
		            + "1 - per aggiungere un elemento al catalogo %n"
		            + "2 - per rimuovere un elemento tramite ISBN %n"
					+ "3 - per trovare un articolo con ISBN %n" 
		            + "4 - per trovare un articolo tramite anno %n"
					+ "5 - per trovare un libro tramite autore %n" 
		            + "6 - per scrivere il file sul disco %n"
					+ "7 - per leggere il file dal disco %n" 
					+ "8 - per cancellare il file %n" 
		            + "0 - per terminare il programma %n");
			try {
			 start = Integer.parseInt(sc.nextLine());

			switch (start) {
			case 1:
				boolean choose = true;
				while(choose) {
				System.out.printf("Scegli tra 1-Rivista  2-Libro: " );
				int res1 = Integer.parseInt(sc.nextLine());
				
					if(res1 == 1) {
						aggiungiElemento(listaRiviste);
						 choose = false;
					}else if(res1 == 2) {
						aggiungiElemento(listaLibri);
						 choose = false;
					}else {
						System.out.println("numero digitato incorretto!");
					}
				}
				break;
			case 2:
				System.out.println("Digita ISBN: " );
				String res2 = sc.nextLine();
				rimuoviDaISBN(res2);
				break;
			case 3:
				System.out.println("Digita ISBN: " );
				String res3 = sc.nextLine();
				ricercaDaISBN(res3);
				break;
			case 4:
				System.out.println("Digita anno(Y-M-D): " );
				String res4 = sc.nextLine();
				ricercaPerAnno(LocalDate.parse(res4));
				break;
			case 5:
				System.out.println("Digita autore: " );
				String res5 = sc.nextLine();
				ricercaPerAutore(res5);
				break;
			case 6:
				try {
					scriviFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					leggiFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				cancellaFile();
			}
			
			}catch(NumberFormatException e) {
				logger.info("Puoi digitare solo numeri");
			}
		} while (start != 0);

		logger.info("Hai chiuso il programma");
		
		
	}
		
		
		

	
	
	//METODI
	//Features richieste
	
	//Aggiunta di un elemento
	public static void aggiungiElemento(List<?> unknown) {
		
		System.out.println("Inserisci le informazioni richieste ");
		
		if( unknown.get(0).getClass() == Libro.class) {
			isbn++;
			String isbn = createISBN();
			
			System.out.println("Titolo: ");
			String titolo = sc.nextLine();

			System.out.println("Anno: ");
			LocalDate anno = (LocalDate.ofYearDay(Integer.parseInt(sc.nextLine()), 1));

			System.out.println("Numero di pagine: ");
			int numeroPagine = Integer.parseInt(sc.nextLine());

			System.out.println("Autore: ");
			String autore = sc.nextLine();

			System.out.println("Genere: ");
			String genere = sc.nextLine();

		     archivio.add(new Libro(isbn, titolo, anno, numeroPagine, autore, genere));
			 logger.info("Libro aggiunto");
			 logger.info("Dettagli ibro aggiunto: " + archivio.get((archivio.size())-1).toString());
			
			
		}else if(unknown.get(0).getClass() == Rivista.class) {
			String isbn = createISBN();
			
			System.out.println("Titolo: ");
			String titolo = sc.nextLine();

			System.out.println("Anno: ");
			LocalDate anno = (LocalDate.ofYearDay(Integer.parseInt(sc.nextLine()), 1));

			System.out.println("Numero di pagine: ");
			int numeroPagine = Integer.parseInt(sc.nextLine());
			
			System.out.println(
					"Periodicita della rivista:" + " 1 - Settimanale" + " 2 - Mensile" + " 3 - Semestrale");
			int res = Integer.parseInt(sc.nextLine());
			Periodicita periodicita = null;
			
			switch (res) {
			case 1:
				periodicita = Periodicita.SETTIMANALE;
				break;
			case 2:
				periodicita = Periodicita.MENSILE;
				break;
			case 3:
				periodicita = Periodicita.SEMESTRALE;
				break;
			}
			
		    archivio.add(new Rivista(isbn, titolo, anno, numeroPagine, periodicita));
			logger.info("Rivista aggiunta");
		}else {
			logger.info("Errore");
		}
	}
	
	//Rimozione di un elemento da ISBN
	public static void rimuoviDaISBN(String isbn) {
		archivio.removeIf(el-> el.getIsbn().equals(isbn));
		logger.info("Elemento rimosso tramite ISBN: " + isbn);
	}
	
	//Ricerca per ISBN
	public static void ricercaDaISBN(String isbn) {
	Stream<ElementoCatalogo> libro  = archivio.stream().filter(el-> el.getIsbn().equals(isbn));
	 libro.forEach(el-> logger.info("Libro con ISBN " + isbn + ": " + el.toString()));
	} 
	
	//Ricerca x anno di pubblicazione
	public static void ricercaPerAnno(LocalDate anno) {
	Stream<ElementoCatalogo> libro  = archivio.stream().filter(el-> el.getAnnoPubblicazione().equals(anno));
		 libro.forEach(el-> logger.info("Libro pubblicato nel " + anno + ": " + el.toString()));
		} 
	
	//Ricerca x autore
	 public static void ricercaPerAutore(String autore) {
     Stream<Libro> libroAutore = 
    		 archivio
					.stream()
					.filter(el -> el instanceof Libro).map(e -> (Libro) e)
					.filter(el -> el.getAutore().equals(autore));
			libroAutore
			.forEach(el -> logger.info("Libri dell'autore " + autore + ": " + el.toString()));
		} 
	 
	//Salvataggio su disco(scrivi)
	 public static void scriviFile() throws IOException {
		 archivio.forEach(el-> {
			 try {
				FileUtils.writeStringToFile(fileArchivio, el.toString(), "UTF-8",true);
				logger.info("Elemento salvato nel file con successo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 });
			
		}
		

	//Caricamento dal disco(leggi)
		public static void leggiFile() throws IOException {
			String txtFile = FileUtils.readFileToString(fileArchivio, "UTF-8");
			String[] obj = txtFile.split("#");
			for (int i = 0; i < obj.length; i++) {
				logger.info(obj[i]);
			}
		}
		
		
	
	//Features extra
	
	//crea isbn 
	public static String createISBN(){
		double d = isbn + Math.random()*Double.MAX_VALUE ;
		String s =String.valueOf(d);  
		return s;
	}
	
	//elimina file
	public static void cancellaFile() {
		FileUtils.deleteQuietly(fileArchivio);
		System.out.println("File eliminato");
	}
	
}
