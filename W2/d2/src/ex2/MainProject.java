package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);
	
	static Random random = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		creaLista(5);
		
		List<Integer> listaDue = new ArrayList<Integer>();
		listaDue.add(0);
		listaDue.add(1);
		listaDue.add(2);
		listaDue.add(3);
		listaDue.add(4);
		listaDue.add(5);
		
		pariDispari(listaDue, true);
		pariDispari(listaDue, false);
		
		copiaListaInvertiOrdine(listaDue);

	}

	public static void creaLista(int n) {
		List<Integer> lista = new ArrayList<Integer>();
		int rand = random.nextInt(101);
		
		for(int i=0; i < n; i++) {
			lista.add(rand);
		}
		System.out.println("Hai creato una lista di " + lista.size() + " numeri casuali");
	}
	public static void copiaListaInvertiOrdine(List<Integer> l) {
		List<Integer> listaCopia = new ArrayList<Integer>();
		listaCopia = l;
		System.out.println("Copied list: " + listaCopia);
		Collections.reverse(listaCopia);
		System.out.println("Reverse list: " + listaCopia);
	}
	public static void pariDispari(List<Integer> l, boolean b) {
		for(int i=0; i<l.size(); i++) {
			if(b == true && i%2 == 0) {
				System.out.println(l.get(i));
			}else if(b == false && !(i%2 == 0)){
				System.out.println(l.get(i));
			}
		}
		
	}
}
