package com.GestioneIncendi.sonda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SondaDto {

	private long idSonda;
	private double latitude;
	private double longitude;
	private int smokeLevel;
	@Override
	public String toString() {
		return "SONDA [id=" + idSonda + ", latitude=" + latitude + ", longitude=" + longitude + ", smokeLevel="
				+ smokeLevel + "]";
	}
	
	
}
