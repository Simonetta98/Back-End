package java_epi;

public class MainEcommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[] arr = {"ART1", "ART2", "ART3"};
		
		Cliente cliente1 = new Cliente ("COD01", "Mario Rossi", "mario@gmail.com", "22/05/2022");
		Articolo articolo1 = new Articolo ("ART1", "Mouse da gaming.", 15.50, 8);
		Carrello carrello1 = new Carrello ("COD01", arr, Articolo.totArticoli);
		
		System.out.println("CLIENTE: ");
		cliente1.stampaCliente();
		
		System.out.println("ARTICOLO: ");
		articolo1.stampaArticolo();
		
		System.out.println("CARRELLO: ");
		carrello1.stampaCarrello();
		

	}

}
