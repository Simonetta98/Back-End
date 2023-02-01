package esercizio3;

import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
		System.out.print("Scrivi una parola:");
		String parola = sc.nextLine();
		
		if(parola.equals(":q")) {
			System.out.print("FINE");
			return;
		}
		
		String[] arrParole = parola.split("");
		
		String virgola = "";
		
		for(int i=0; i<arrParole.length; i++) {
			if(i == arrParole.length-1) {
				virgola += arrParole[i];
			}else {
				virgola += arrParole[i] + ",";
			}
			
		}
		System.out.println(virgola);

	}
	
  }
	
}
