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
public class Pizza extends InfoProduct {
	private Ingredienti salsa = Ingredienti.SALSA_POMODORO;
	 private Ingredienti mozzarella = Ingredienti.MOZZARELLA;
}
