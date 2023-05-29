package com.epicode.config_bean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationTest {
	
	//Crea un bean di tipo Test
	@Bean
	@Scope("singleton")
	public Test test() {
		return new Test("Primo Bean", "Costruzione primo bean da file Configuration!");
	}
	
	//Crea un bean di tipo Test
	@Bean
	@Scope("prototype")
	public Test paramTest(String txt) {
		return new Test("Secondo Bean", txt);
	}
	
	//Crea un bean di tipo Test
	@Bean
	@Scope("prototype")
	public Test paramAllTest(String title, String txt) {
		return new Test(title, txt);
	}

}
