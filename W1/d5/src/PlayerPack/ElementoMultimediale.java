package PlayerPack;

public abstract class ElementoMultimediale {
	
	private String titolo;
	private int durata;

	public int isImage;
	
//constructor
	
	public ElementoMultimediale (String titolo, int durata) {
		this.titolo = titolo;
		this.durata = durata;
	}
	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}
	
//get&set
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public int getDurata() {
		return durata;
	}
	
//methods
	public void play() {
		
	}
	public void show() {
		
	}
}
