package PlayerPack;

public class Audio extends ElementoMultimediale implements Volume {
	
      int volume;

//construtor

	public Audio(String titolo, int durata, int volume) {
		super(titolo, durata);
		this.volume = volume;
	}

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
	if(volume < 0) {
		
		this.volume = 0;
		System.out.println("il volume deve essere almeno 1");
	}
	return volume;
}

//PLAY titolo + volume (sequenza di !)
@Override
public void play() {
	if (getDurata() > 0) {
		for (int i = 1; i <= this.getDurata(); i++) {
			System.out.printf(" Titolo: " + getTitolo() + ", Minuti: " + i);
			System.out.printf(" Volume: ");
			for (int a = 0; a < this.getVolume(); a++) {
				System.out.printf("!");
			}
			System.out.println();
		}
	}else
	System.out.println("la durata deve essere almeno 1");
}


}
