package esercizio2;

import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Scrivi un numero:");
		int numero = Integer.parseInt(sc.nextLine());
		stampaLettere(numero);

	}
	
	//methods
	public static void stampaLettere(int num) {
		switch(num) {
		case 0 :
			System.out.println("ZERO");
			break;
		case 1 :
			System.out.println("UNO");
			break;
		case 2 :
			System.out.println("DUE");
			break;
		case 3 :
			System.out.println("TRE");
			break;
		default:
			System.out.println("Errore: il numero deve essere compreso tra 0 e 3");	
		}
		
	}

}
