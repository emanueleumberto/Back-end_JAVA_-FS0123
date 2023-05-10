package com.epicode.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaProject {

	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(JavaProject.class);
		
		TestThread t1 = new TestThread("Primo Thread");
		TestThread t2 = new TestThread("Secondo Thread");
		Test2Thread t3 = new Test2Thread();
		Thread t4 = new Thread(new TestRunnable("Primo Thread Runnable"));
		Thread t5 = new Thread(new TestRunnable("Secondo Thread Runnable"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		log.info("FINE");

	}

}
