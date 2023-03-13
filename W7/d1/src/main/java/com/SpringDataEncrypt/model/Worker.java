package com.SpringDataEncrypt.model;


import com.SpringDataEncrypt.configuration.SecretCodeConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "workers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Worker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Convert(converter = SecretCodeConverter.class)
	private String secretPassword;

}
