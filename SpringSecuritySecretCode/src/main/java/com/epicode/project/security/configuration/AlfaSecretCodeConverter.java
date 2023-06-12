package com.epicode.project.security.configuration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AlfaSecretCodeConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		System.out.println(attribute);
		String result = "";
		if(attribute == null) {
			return result;
		}
		for(Character c : attribute.toCharArray()) {
			int cod = c;
			char newChar = (char) (cod+3);
			result += newChar;
			//System.out.println(cod);
			//System.out.println(newChar);
		}
		System.out.println(result);
		return result;
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		String result = "";
		if(dbData == null) {
			return result;
		}
		for(Character c : dbData.toCharArray()) {
			int cod = c;
			char newChar = (char) (cod-3);
			result += newChar;
		}
		return result;
	}

}
