package com.epicode.config_bean.introSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epicode.config_bean.configuration.ConfigurationTest;
import com.epicode.config_bean.configuration.Test;
import com.epicode.config_bean.configurationComponent.TestComponent;
import com.epicode.config_bean.configurationXML.TestXML;

@SpringBootApplication
public class IntroSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringApplication.class, args);
		
		System.out.println("Run...");
	
		// Metodo 1
		// Configurazione tramite classe @Configuration
		// configWith_Bean();
		
		// Metodo 2
		// Configurazione tramite file XML
		// configWith_XML();
		
		// Metodo 3
		// Configurazione tramite @Component
		 configWith_Component();
	
	}

	public static void configWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationTest.class);
		
		// Recupero il Bean test
		Test t1 = (Test) appContext.getBean("test");
		System.out.println(t1.readTxt());
		
		// Recupero il Bean paramTest
		// getBean(param1: nome del bean, param2: parametri da passare al bean, ...param)
		Test t2 = (Test) appContext.getBean("paramTest", "Costruzione bean con parametri!");
		System.out.println(t2.readTxt());
		
		// Recupero il Bean paramAllTest
		Test t3 = (Test) appContext.getBean("paramAllTest", "Terzo Bean", "Costruzione bean con tutti i parametri!");
		System.out.println(t3.readTxt());
		
		
		// Chiudo il Context
		appContext.close();
	}

	public static void configWith_XML() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		// Recupero il Bean testXML tramite l'ID del tag bean nel file beans.xml
		TestXML t1 = (TestXML) appContext.getBean("testXML");
		System.out.println(t1.readTxt());
		
		// Chiudo il Context
		appContext.close();
	}

	public static void configWith_Component() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		
		appContext.scan("com.epicode.config_bean.configurationComponent");
		appContext.refresh();
			
		// Recupero il Bean test
		TestComponent t1 = (TestComponent) appContext.getBean("TestComponent");
		t1.setTitle("Primo Bean");
		t1.setTxt("Costruzione bean con @Component");
		System.out.println(t1.readTxt());
		
		// Recupero il Bean paramTest
		// getBean(param1: nome del bean, param2: parametri da passare al bean, ...param)
		TestComponent t2 = (TestComponent) appContext.getBean("TestComponent", "Secondo Bean", "Costruzione bean @Component con parametri!");
		System.out.println(t2.readTxt());
		
		// Chiudo il Context
		appContext.close();
	}
}
