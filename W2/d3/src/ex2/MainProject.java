package ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainProject {
	
	static Random rand = new Random();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LIST che conterrà i valori parziali dei Thread
		List<Integer> resParziali = new ArrayList<Integer>();
 
		//Array iniziale
		int tremila[] = new int[3000];
	
		//popolato da valori casuali
		for(int i=0; i<tremila.length; i++) {
			tremila[i] = rand.nextInt(11); //0-10
		}
		
		//controllo
		/*System.out.println(tremila.length);
		System.out.println(tremila[2]);
		System.out.println(tremila[3]);
		System.out.println(tremila[4]);*/
		
		//Creo i thread 
		//il risultato saranno dei nuovi array che copiano 1000 valori a seguire dell'array iniziale sommandoli
		ThreadSum one = new ThreadSum(tremila, 0, 999);
		ThreadSum two = new ThreadSum(tremila, 1000, 1999);
		ThreadSum three = new ThreadSum(tremila, 2000, 2999);
		
		one.start();
		two.start();
		three.start();
		
		//Aspetto ogni Thread e aggiungo i valori della somma parziale nella Lista
		try {
			one.join();
			resParziali.add(one.getSomma());
			two.join();
			resParziali.add(two.getSomma());
			three.join();
			resParziali.add(three.getSomma());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resParziali.toString());
		
		//SOMMA valori parziali
		int sumParziali = resParziali.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sumParziali);
	}
	

}
