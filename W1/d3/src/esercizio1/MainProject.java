package esercizio1;

import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Scrivi una parola:");
		String parola = sc.nextLine();
		stringaPariDispari(parola);
		
		System.out.print("Scrivi un anno:");
		int anno = Integer.parseInt(sc.nextLine());
		annoBisestile(anno);

	}
	
	//methods
	//#1
	public static void stringaPariDispari(String str) {
		if(str.length()%2 == 0) {
			System.out.println("Questa stringa è pari");
		}else {
			System.out.println("Questa stringa è dispari");
		}
	}
	
	//#2
	public static void annoBisestile(int anno) {
		if(anno%4 == 0) {
			if(anno%100 == 0 && anno%400 == 0) {
				System.out.println("È un anno bisestile");   //1600,2000,2400...
			}else {
				System.out.println("Non è un anno bisestile");;
			}
		}else {
			System.out.println("Non è un anno bisestile");
		}
		
	}

}
