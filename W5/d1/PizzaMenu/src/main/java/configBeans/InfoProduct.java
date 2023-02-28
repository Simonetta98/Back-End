package configBeans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class InfoProduct {
	
	private String productName;
	private Double productPrice;
	
	 public String infoProduct() {
		 	return this.productName.toUpperCase() + ", prezzo: " + this.productPrice + " €";
		 }
}
