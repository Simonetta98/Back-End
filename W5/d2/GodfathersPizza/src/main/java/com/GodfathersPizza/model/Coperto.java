package com.GodfathersPizza.model;


import java.util.concurrent.atomic.AtomicInteger;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@PropertySource("classpath:application.properties")
public class Coperto {

	private static final AtomicInteger idGenerator = new AtomicInteger(1);
	
	private final int ID = idGenerator.getAndIncrement();
	
	//@Value("${application.coperto.value}")
	private double prezzo = 1.50;
	
	

	@Override
	public String toString() {
		return "Coperto [prezzo=" + prezzo + " ID=" + ID + "]";
	}

	
	
}
