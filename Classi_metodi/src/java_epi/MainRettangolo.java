package java_epi;

public class MainRettangolo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rettangolo primo = new Rettangolo(15, 25);
		Rettangolo secondo = new Rettangolo(5, 15);
		
		System.out.println(primo.perimetro());
		System.out.println(primo.area());
		
		Rettangolo.stampaRettangolo(primo);
		Rettangolo.stampaRettangolo(secondo);
		Rettangolo.stampaDueRettangoli(primo, secondo);

	}

}
