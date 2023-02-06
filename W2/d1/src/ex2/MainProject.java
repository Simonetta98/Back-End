package ex2;

import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Inserisci i km percorsi: ");
			int km = Integer.parseInt(sc.nextLine()) ;
			
			System.out.println("Inserisci i litri consumati: ");
			int litri = Integer.parseInt(sc.nextLine()) ;
			
			System.out.println("Questi sono i Lt consumati per km: ");
			System.out.println(calcola(km, litri));

		}catch (ArithmeticException e) {
			System.out.println("Non puoi dividere un numero per 0 ");
		}
		
	}

 static int calcola(int km, int l) {
		int consumo = 0;
		consumo = km/l;
		return consumo;
   }
}
