package esercizio1;

public class Dipendente {
	
//public static double stipendioBase = 1000;
//Soluzione alternativa per il problema degli stipendi diversi in base al ruolo;
//lo stipendioBase non può essere uguale per tutti, a seconda di chi assumo varia in base al livello;
//anche gli aumenti cambiano;
	private double stipendioBase = 0;

private String matricola;    //try static and every worker increments +1
private double stipendio;
private double importoOrarioStraordinario;
private Livello livello;
private Dipartimento dipartimento;

//getters

public String getMatricola() {
	return matricola;
}


public double getStipendio() {
	return stipendio;
}

public Livello getLivello() {
	return livello;
}


//getters&setters

public double getStipendioBase() {
	return stipendioBase;
}
public double setStipendioBase(Livello liv) {
	switch (liv) {
	case OPERAIO:
		this.stipendioBase = 1000;
		break;
	case IMPIEGATO:
		this.stipendioBase = 1300;
		break;
	case QUADRO:
		this.stipendioBase = 1600;
		break;
	case DIRIGENTE:
		this.stipendioBase = 2200;
		break;
}
	return getStipendioBase();
	
}


public double getImportoOrarioStraordinario() {
	return importoOrarioStraordinario;
}
public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
	this.importoOrarioStraordinario = importoOrarioStraordinario;
}

public Dipartimento getDipartimento() {
	return dipartimento;
}
public void setDipartimento(Dipartimento dipartimento) {
	this.dipartimento = dipartimento;
}


 //constructors

public Dipendente (String matricola, Dipartimento dipartimento) {
	this.matricola = matricola;
	this.dipartimento = dipartimento;
	this.importoOrarioStraordinario = 30;
	this.livello = Livello.OPERAIO;
	
	//this.stipendio = Dipendente.stipendioBase;
	this.stipendio = setStipendioBase(this.livello); //in base al livello ho lo stipendioBase
}

public Dipendente (String matricola, /*double stipendio,*/ double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
	this.matricola = matricola;
	this.importoOrarioStraordinario = importoOrarioStraordinario;
	this.livello = livello;
	
	this.stipendio = setStipendioBase(this.livello); //in base al livello ho lo stipendioBase
	this.dipartimento = dipartimento;
}


//methods

public String toString() { //stampaDipendente
	return "matricola: " + matricola + " dipartimento: " + dipartimento + " stipendio: " + stipendio + " importoOrarioStraordinario: " + importoOrarioStraordinario + " livello: " + livello;
}

public void promuovi() {
	
	System.out.println("PROMOZIONE:");
	
	switch (this.livello) {
		case OPERAIO:
			this.livello = Livello.IMPIEGATO;
			this.stipendio = stipendioBase + 300; /* invece di stipendioBase * 1.2 */
			break;
		case IMPIEGATO:
			this.livello = Livello.QUADRO;
			this.stipendio = stipendioBase + 300;  /* invece di stipendioBase * 1.5 */
			break;
		case QUADRO:
			this.livello = Livello.DIRIGENTE;
			this.stipendio = stipendioBase + 600;  /* invece di stipendioBase * 2 */
			break;
		case DIRIGENTE:
			System.out.println("Errore: il dipendente " + this.matricola + " è già al livello: " + this.livello);
			break;
	}
	
	if ( this.livello != Livello.DIRIGENTE) {
		System.out.println("Dipendente " + this.matricola + " promosso a: " + this.livello + ".");
		System.out.println("Nuovo stipendio: " + this.stipendio);
	}
};

//static methods

public static double calcolaPaga(Dipendente dip) {
	return dip.stipendio;
}
public static double calcolaPaga (Dipendente dip, int ore) {
	double extra = dip.importoOrarioStraordinario * ore;
	return dip.stipendio + extra;		
};

}
