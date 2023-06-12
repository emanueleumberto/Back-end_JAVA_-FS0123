package com.epicode.project.security.configuration;

import jakarta.persistence.AttributeConverter;

public class SecretCodeConverter implements AttributeConverter<String, String> {
	
	Character[] arrChar = {'P', 'Q', 'A', '@', 'O', 'U', 'B', 'W', '!', '-'};

	@Override
	public String convertToDatabaseColumn(String attribute) {
		//"3852" -> @!UA
		String result = "";
		if(attribute == null) {
			return result;
		}
		for(Character c : attribute.toCharArray()) {
			String s = c.toString(); // "3" "8" "5" "2"
			int num = Integer.parseInt(s); // 3 8 5 2 
			result += arrChar[num]; // @ ! U A 
		}
		
		return result; // @!UA
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		//@!UA -> "3852"
		
		String result = "";
		if(dbData == null) {
			return result;
		}
		
		for(Character c : dbData.toCharArray()) {
			// @ ! U A
			for(int i=0; i<arrChar.length; i++) {
				if(arrChar[i].equals(c)) {
					result += i; // 3 8 5 2
				}
			}
		}
		return result; // "3852"
	}

}
