package com.GodfathersPizza.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class PostoVuoto extends Coperto {

	private String info = "il posto è rimasto vuoto";
	
	@Override
	public double getPrezzo() {
		// TODO Auto-generated method stub
		return super.getPrezzo();
	}

	@Override
	public void setPrezzo(double prezzo) {
		// TODO Auto-generated method stub
		super.setPrezzo(prezzo);
	}

}
