package PlayerPack;

public class Video extends ElementoMultimediale implements Volume, Luminosità {
	
	private int volume;
	private int luminosita;
	
	public Video(String titolo, int durata, int luminosita, int volume) {
		super(titolo, durata);
		this.luminosita = luminosita;
		this.volume = volume;
		
	}
	
	//luminosità
	
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
	
	//volume
	
	@Override
	public int alzaVolume() {
		// TODO Auto-generated method stub
		return ++volume;
	}

	@Override
	public int abbassaVolume() {
		// TODO Auto-generated method stub
		return --volume;
	}

	@Override
	public int getVolume() {
		// TODO Auto-generated method stub
		
		//il volume ha un minimo e un massimo
		if(volume < 0) {
			this.volume = 0;
			System.out.println("il volume deve essere almeno 1");
		}
		return volume;
	}
	
	@Override
	public void play() {
		if (getDurata() > 0) {
			for (int i = 1; i <= getDurata(); i++) {
				System.out.printf(" Titolo: " + getTitolo() + ", Minuti: " + i);
				System.out.printf(" Volume: ");
				for (int a = 0; a < this.getVolume(); a++) {
					System.out.printf("!");
				}
				System.out.printf(" Luminosità: ");
				for (int b = 1; b <= this.luminosita; b++) {
					System.out.printf("*");
				}
				System.out.println();
			}
		} else 
			System.out.println("la luminosità deve essere almeno 1");
	}

}
