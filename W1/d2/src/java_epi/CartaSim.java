package java_epi;

public class CartaSim {
	String numero;
	int credito = 0;  // your credit is 0
	String[][] chiamate = {    // 2D array 
			    {},
			    {},
			    {},
			    {},
			    {}
		     }; 
	
	//constructor
	public CartaSim(String numero, int credito, String[][] chiamate) {
		this.numero = numero;
		this.credito = credito;
		this.chiamate = chiamate;
	}
	
	//methods
	static void stampaSim(CartaSim x) {
		System.out.println("Il tuo numero:");
		System.out.println(x.numero);
		System.out.println("credito");
		System.out.println(x.credito);
		System.out.println("Registro chiamate:");
		System.out.println(java.util.Arrays.deepToString(x.chiamate)); // to read 2D array
	}

}
