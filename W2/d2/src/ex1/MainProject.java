package ex1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);
	
	static Set<String> set = new HashSet<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.out.println("Numero di elementi da inserire: ");
		int insert = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i < insert; i ++ ) {
			System.out.println("Inserisci le parole: ");
			String word = sc.nextLine();
			
			if(!set.contains(word)) {
				set.add(word);
			}else {
				System.out.print("Questa parola è già stata inserita\n");
			}
		}
		System.out.print("Lunghezza set: ");
		stampaNumeroParole(set);
		System.out.print("Elenco elementi: ");
		stampaSet();
	}
	
   public static void stampaNumeroParole(Set<String> s) {
    	System.out.println(s.size());
	}
   public static void stampaSet() {
		for (String s : set) {
			System.out.println(s.toString());
		}
		
	}

}
