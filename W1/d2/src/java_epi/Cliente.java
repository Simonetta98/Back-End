package java_epi;

public class Cliente {
	String codice;
	String nomeCognome;
	String email;
	String dataIscrizione;
	
	public Cliente (String codice, String nomeCognome, String email, String dataIscrizione) {
		this.codice = codice;
		this.nomeCognome = nomeCognome;
		this.email = email;
		this.dataIscrizione = dataIscrizione;
	}
	
	public void stampaCliente() {
		System.out.println("Codice cliente: " + this.codice);
		System.out.println("Nome e cognome: " + this.nomeCognome);
		System.out.println("Email: " + this.email);
		System.out.println("Data iscrizione: " + this.dataIscrizione);
	}

}
