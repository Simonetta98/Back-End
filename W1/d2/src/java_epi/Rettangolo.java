package java_epi;

public class Rettangolo {
	int altezza;
	int larghezza;
	
	//constructor
	public Rettangolo(int altezza, int larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	//methods (public)
	public int perimetro() {
		int res = (this.altezza + this.larghezza)*2;
		return res;
	}
	public int area() {
		int res = this.altezza * this.larghezza;
		return res;
	}
	
	//methods (static)
	static void stampaRettangolo(Rettangolo x) {
		System.out.println("Altezza: " + x.altezza + " Larghezza: " + x.larghezza);
	}
	static void stampaDueRettangoli(Rettangolo x, Rettangolo y) {
		System.out.println("Primo rett. a= " + x.area() + " p= " + x.perimetro());
		System.out.println("Secondo rett. a= " + y.area() + " p= " + y.perimetro());
		
		int sommaP = x.perimetro() + y.perimetro();
		int sommaA = x.area() + y.area();
		System.out.println("Somma P = " + sommaP + ", somma A = "+ sommaA);
	}

}
