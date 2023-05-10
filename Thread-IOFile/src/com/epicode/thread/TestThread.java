package com.epicode.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestThread extends Thread {
	
	private Logger log = LoggerFactory.getLogger(TestThread.class);
	private String message;
	
	public TestThread(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				log.info("N." + i + " - " + message);
				Thread.sleep(1000);
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
