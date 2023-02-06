package ex1;

import java.util.Arrays;
import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);
	static boolean tf = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numArray = new int[5];
		for(int i=0; i<numArray.length; i++) {
			numArray[i] = (int)(Math.random() * 10) + 1; 
		}
		System.out.println(Arrays.toString(numArray));
		
		
		while(tf == true) {
            try {
            	System.out.println("Inserisci un numero: ");
    			
    			int num = Integer.parseInt(sc.nextLine());
    			
    			if(num!=0) {
    	        System.out.println("Inserisci l'indice: ");
    			
    			int index = Integer.parseInt(sc.nextLine());
    			
    				numArray[index] = num;
    				
    				System.out.println("OK " + Arrays.toString(numArray));		
    				
    			}else {
    				tf = false;
    			}
				
			} catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("L'indice deve essere compreso tra 0 e 4");
				
			} catch(NumberFormatException ex) {
				System.out.println("Devi inserire un numero!");
				
			} catch(Exception err) {
				System.out.println("Qualcosa è andato storto...");
			}

		}
		sc.close();
		
		System.out.println("FINAL ARR " + Arrays.toString(numArray));

	}

}
