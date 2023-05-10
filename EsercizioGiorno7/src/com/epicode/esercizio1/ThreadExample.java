package com.epicode.esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadExample implements Runnable {
	
	private String simbolo;
	private Logger log = LoggerFactory.getLogger(ThreadExample.class);

	public ThreadExample(String simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				log.info(simbolo);
				Thread.sleep(1000);
			} 
		} catch (InterruptedException e) {
			log.error("Errore " + e.getMessage());
			//e.printStackTrace();
		}
		
	}

}
