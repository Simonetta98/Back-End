package PlayerPack;

public class Immagine extends ElementoMultimediale implements Luminosità {
	
	private int luminosita;
	

	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}


	@Override
	public int alzaLuminosita() {
		// TODO Auto-generated method stub
		return ++luminosita;
	}


	@Override
	public int abbassaLuminosita() {
		// TODO Auto-generated method stub
		return --luminosita;
	}


	@Override
	public int getLuminosita() {
		// TODO Auto-generated method stub
		return luminosita;
	}
	
//SHOW immagine
	
	public void show() {
		System.out.printf("Titolo: " + getTitolo() + " Luminosità: ");
			for (int i = 1; i <= this.luminosita; i++) {
				System.out.printf("*");
			}
	}

}
