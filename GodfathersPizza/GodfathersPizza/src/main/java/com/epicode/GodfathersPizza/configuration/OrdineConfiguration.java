package com.epicode.GodfathersPizza.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.epicode.GodfathersPizza.model.Ordine;
import com.epicode.GodfathersPizza.model.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class OrdineConfiguration {
	
	@Value("${GodfathersPizza.costocoperto}") private Double costoCoperto;
	
	@Bean
	@Scope("prototype")
	public Tavolo tavolo(int numeroTavolo, int numeroCoperti) {
		return new Tavolo(numeroTavolo, numeroCoperti);
	}
	
	@Bean
	@Scope("prototype")
	public Ordine ordine(int numeroOrdine, Tavolo tavolo, int numeroCoperti) {
		try {
			return new Ordine(numeroOrdine, tavolo, numeroCoperti, costoCoperto);
		} catch (Exception e) {
			return null;
		}
		
	}

}
