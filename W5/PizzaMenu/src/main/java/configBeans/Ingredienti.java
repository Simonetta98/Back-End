package configBeans;

public enum Ingredienti {

	SALSA_POMODORO(1),
	MOZZARELLA(2),
	OLIVE(1),
	SALAME_PICCANTE(2),
	MELANZANE_FRITTE(2),
	RICOTTA_SALATA(1),
	UOVA(2),
	PROSCIUTTO_COTTO(2),
	FUNGHI(2);

	
	public final int value;

	Ingredienti(final int value) {
	     this.value = value;
	  }
	
	Ingredienti getValue(int value) {
		  for(Ingredienti e: Ingredienti.values()) {
		    if(e.value == value) {
		      return e;
		    }
		  }
		  return null;// not found
		}
}
