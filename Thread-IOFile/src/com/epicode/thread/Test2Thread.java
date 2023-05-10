package com.epicode.thread;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test2Thread extends Thread {
	
	private Logger log = LoggerFactory.getLogger(TestThread.class);
	
	@Override
	public void run() {
		char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'l'};
		for (int i = 0; i < 10; i++) {
			try {
				log.info("Char: " + arr[i]);
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		
//		Random rand = new Random();
		
	}

}
