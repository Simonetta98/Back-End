package configBeans;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigProducts {

	@Bean
	@Scope("prototype")
	public Pizza createPizza(String name, Double price) {
		Pizza pizza = new Pizza();
		pizza.setProductName(name);
		pizza.setProductPrice(price);
		return pizza;
	}
	
	@Bean
	@Scope("prototype")
	public Pizza addExtra(Pizza pizza, List<Ingredienti> list) {
		Pizza p = new ExtrasDecorator(pizza, list);
		return p;
	}
	
}
