package configBeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExtrasDecorator extends Pizza {
 
	Pizza pizza;
	List <Ingredienti> listExtra = new ArrayList<Ingredienti>();

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return pizza.getProductName() + " con extra " + listExtra.toString();
	}

	@Override
	public Double getProductPrice() {
		// TODO Auto-generated method stub
	Double sum = 0.00;
	 for (Ingredienti i : listExtra)
         sum = sum + i.value;

     return pizza.getProductPrice() + sum;
	}
	
	@Override
	public String infoProduct() {
		if(listExtra.containsAll(Arrays.asList(Ingredienti.MELANZANE_FRITTE, Ingredienti.RICOTTA_SALATA))) {
			pizza.setProductName("Norma");
			pizza.setProductPrice(8.00);
	 	return this.getProductName().toUpperCase() + ", prezzo: "+ this.getProductPrice() + " €";
	 	
	 }else if(listExtra.containsAll(Arrays.asList(Ingredienti.OLIVE, Ingredienti.SALAME_PICCANTE))) {
		    pizza.setProductName("Diavola");
			pizza.setProductPrice(7.50);
	 	return this.getProductName().toUpperCase() + ", prezzo: "+ this.getProductPrice() + " €";
	 	
	 }else if(listExtra.containsAll(Arrays.asList(Ingredienti.OLIVE, Ingredienti.PROSCIUTTO_COTTO, Ingredienti.UOVA))) {
		    pizza.setProductName("Capricciosa");
			pizza.setProductPrice(8.50);
	 	return this.getProductName().toUpperCase() + ", prezzo: "+ this.getProductPrice() + " €";
	 	
	 }else {
		 return this.getProductName().toUpperCase() + ", prezzo: "+ this.getProductPrice() + " €";
	 }
   }
}
