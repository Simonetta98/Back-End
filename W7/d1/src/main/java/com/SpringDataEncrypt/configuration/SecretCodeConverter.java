package com.SpringDataEncrypt.configuration;




import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import jakarta.persistence.AttributeConverter;

public class SecretCodeConverter implements AttributeConverter<String, String> {

	
	@Override
	public String convertToDatabaseColumn(String attribute) {
		String encoded = "";
		
		if(attribute == null) {
			return encoded;
		}
		
		//ENCODE
		encoded = new String(Base64.getEncoder().encode(attribute.getBytes(StandardCharsets.UTF_8)));
		return encoded;
		
		
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		String decoded = "";
		
		//DECODE
		decoded = new String(Base64.getDecoder().decode(dbData), StandardCharsets.UTF_8);
			
		return decoded;
	}

}
