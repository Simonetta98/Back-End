package ex3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	
	static File file = new File("dirFile/test.txt");
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		file.getParentFile().mkdirs();

		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(file.exists());
		
		////////////////////////////////////
		
		String nome;
		int giorniPresenza;
		boolean esci = false;
		
		while(esci == false) {
			System.out.println("Inserisci nome: ");
			nome = sc.nextLine();
			System.out.println("Inserisci giorni di presenza: ");
			giorniPresenza = Integer.parseInt(sc.nextLine());
			
			List<String> presenze = new ArrayList<String>();
			
			List<String> presenzeInMemoria = new ArrayList<String>();
			
			presenze.add(nome + "@" + giorniPresenza + "#");
			
			System.out.println(presenze);
			
			for(int i=0; i<presenze.size(); i++) {
				try {
					scriviFile(presenze.get(i));
					String testoDaFile = leggiFile();
					System.out.println("Testo inserito: " + testoDaFile);
					scriviMemoria(testoDaFile, presenzeInMemoria);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
			System.out.println("Oggetti istanziati in memoria da file: " + presenzeInMemoria.toString());
			
			System.out.println("Vuoi inserire altro? y/n");
			if(sc.nextLine() == "n") {
				System.out.println("Registro chiuso");
				esci = true;
			}
		 
		}
		
	}
	
	
	public static void scriviFile(String testo) throws IOException {
		FileUtils.writeStringToFile(file, testo, "UTF-8",true);
		System.out.println("Testo inserito nel file con successo");
	}
	
	public static String leggiFile() throws IOException {
		String txtFile = FileUtils.readFileToString(file, "UTF-8");
		return txtFile;
	}
	
	public static void scriviMemoria(String f, List<String> list) {
		String[] parts = f.split("#");
		for(int i=0; i<parts.length; i++) {
			list.add(parts[i]);
		}
		
	}
	
	public static void cancellaFile() {
		FileUtils.deleteQuietly(file);
		System.out.println("File eliminato");
	}
	
	public static void cancellaDir() throws IOException {
		File file = new File("dirFile/");
		FileUtils.deleteDirectory(file);
		System.out.println("Directory eliminata");
	}

}
