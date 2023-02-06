package ex3;

public class ContoOnline extends ContoCorrente {
	 // TODO Auto-generated constructor stub
	
	double maxPrelievo;
	
	ContoOnline(String titolare, double saldo, double maxP) {
		super(titolare, saldo);
		this.maxPrelievo = maxP;
	}


	void stampaSaldo() {

		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}

	void preleva(double x) throws BancaException {
		if (x <= maxPrelievo) {
			super.preleva(x);
		}else if(x > maxPrelievo) {
			throw new BancaException("Il prelievo non è disponibile");
		}
	}

}
