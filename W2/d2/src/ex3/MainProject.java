package ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainProject {
	
	static Map<String, String> m = new HashMap<String, String>();
	static Set<String> setKey =  m.keySet();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		salvaInRubrica("Mario", "342899999");
		salvaInRubrica("Gloria", "342811111");
		stampaRubrica();
		
		trovaNomePerNumero("342899999");
		trovaNumeroPerNome("Gloria");
	}

	public static void salvaInRubrica(String nome, String telefono) {
		m.put(nome, telefono);
	}
	public static void eliminaDallaRubrica(String nome) {
		m.remove(nome);
	}
	public static void trovaNomePerNumero(String telefono) {
		for (String key : setKey) {
			if(m.get(key) == telefono) {
				System.out.println("Questo è il numero di: " + key);
			}	
		}	
	}
	public static void trovaNumeroPerNome(String nome) {
		String numero = m.get(nome);
		System.out.println("Numero di telefono di " + nome + ": " + numero);
	}
	public static void stampaRubrica() {
		
	for(String key : setKey) {
		 System.out.println(key + " [" +  m.get(key).toString() + "]");
	  }
		
	}
	
}
