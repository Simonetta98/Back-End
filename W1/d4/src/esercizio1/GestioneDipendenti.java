package esercizio1;

public class GestioneDipendenti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Dipendenti
		
		Dipendente primoOp = new Dipendente("10007879", Dipartimento.PRODUZIONE);  //operaio
		Dipendente secondoOp = new Dipendente("10007859", Dipartimento.PRODUZIONE);//operaio
		Dipendente impiegato = new Dipendente("10007890", 40, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);  //impiegato
		Dipendente dirigente = new Dipendente("10007800", 45, Livello.DIRIGENTE, Dipartimento.VENDITE); //dirigente
		
		//stampo
		
		System.out.println(primoOp.toString());
		System.out.println(secondoOp.toString());
		System.out.println(impiegato.toString());
		System.out.println(dirigente.toString());
		
		//promozioni
		
		primoOp.promuovi();   //operaio --> impiegato
		
		impiegato.promuovi();   //impiegato --> quadro
		
		System.out.println(primoOp.toString());
		System.out.println(impiegato.toString());
		
		System.out.println(Dipendente.calcolaPaga(primoOp));
		System.out.println(Dipendente.calcolaPaga(impiegato));
		
		//stipendi con straordinario
		
		Dipendente[] dipendenti = new Dipendente[4];
		dipendenti[0] = primoOp;
		dipendenti[1] = secondoOp;
		dipendenti[2] = impiegato;
		dipendenti[3] = dirigente;
		
		double sum = 0;
		
		for(int i=0; i<dipendenti.length; i++) {
			
			System.out.println("STIPENDIO CON EXTRA: " + Dipendente.calcolaPaga(dipendenti[i], 5));
			
			double[] stipendi = {Dipendente.calcolaPaga(dipendenti[i], 5)};
			
			for(double e : stipendi) {
				sum += e;
			}
		
		}
		
		System.out.println("SOMMA STIPENDI: " + sum);

		
	}

}
