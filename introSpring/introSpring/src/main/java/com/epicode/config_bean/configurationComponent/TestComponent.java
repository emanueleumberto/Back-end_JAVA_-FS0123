package com.epicode.config_bean.configurationComponent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
@Component("TestComponent")
@Scope("prototype")
public class TestComponent {
	
	private String title;
	private String txt;
	
	

	public String readTxt() {
		return "Titolo " + title +  " Testo Test: " + txt;
	}


}
