package esercizio4;

import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Scrivi un numero:");
		int numero = Integer.parseInt(sc.nextLine());
		contoAllaRovescia(numero);

	}
	
	//methods
	public static void contoAllaRovescia(int num) {
		 for(int i=num; i>=0; i--) {
			 System.out.println(i);
		 }
	}

}
