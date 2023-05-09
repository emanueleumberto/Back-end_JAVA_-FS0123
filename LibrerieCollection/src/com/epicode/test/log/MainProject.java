package com.epicode.test.log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	static Logger log = LoggerFactory.getLogger(MainProject.class);

	public static void main(String[] args) {

//		log.info("Test Logger!!!");
//		log.error("Test Error!");
//		log.warn("Test Warning!");
//		log.debug("Test Debug");
		
//		testCollection();
//		testList();
//		testSet();
		testQueue();
//		testMap();
	}
	
	public static void testCollection() {
		Collection<String> c = new ArrayList<String>();
		
		// non memorizza l'ordine in cui sono stati memorizzati i dati
		// non definisce se ci possono essere valori duplicati
		// non può contenere valori primitivi ma classi Wrapper (Integer - Char - Boolean - Double)
		//Collection<Integer> c = new ArrayList<String>();
		
		c.add("Primo Elemento");
		c.add("Secondo Elemento");
		c.add("Terzo Elemento");
		
		boolean cont = c.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento': " + cont);
		
		boolean isEmp = c.isEmpty();
		log.info("Collection isEmpty: " + isEmp);
		
		int size = c.size();
		log.info("Collection size: " + size);
		
		c.forEach(e -> log.info(e));
		
		c.remove("Primo Elemento");
		c.clear();
		
		isEmp = c.isEmpty();
		log.info("Collection isEmpty: " + isEmp);
	}

	public static void testList() {
		List<String> l = new ArrayList<String>();
		// gli oggetti sono memorizzati in base all'ordine di inserimento
		// può contenere valori duplicati
		// consente di aggiungere elementi specificando un indice
		// consente di leggere elementi specificando un indice
		
		l.add("Primo Elemento");
		l.add("Secondo Elemento");
		l.add("Terzo Elemento");
		
		boolean cont = l.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento': " + cont);
		
		boolean isEmp = l.isEmpty();
		log.info("List isEmpty: " + isEmp);
		
		int size = l.size();
		log.info("List size: " + size);
		
		l.remove("Primo Elemento");
		
		// Metodi che definisce List
		String s = l.get(0);
		log.info("List indice 0: " + s);
		
		l.set(1, "Nuovo Elemento");
		
		int index = l.indexOf("Secondo Elemento");
		log.info("List indice 'Secondo Elemento': " + index);
		
		l.forEach(e -> log.info(e));
		
		Object[] arrObj = l.toArray();
		
	}

	public static void testSet() {
		//Set<String> s = new HashSet<String>();
		// gli oggetti non sono memorizzati in base all'ordine di inserimento
		// NON può contenere valori duplicati 
		
		SortedSet<String> s = new TreeSet<String>();
		// gli oggetti sono memorizzati in base all'ordine di inserimento
		// NON può contenere valori duplicati 
		
		s.add("Primo Elemento");
		s.add("Secondo Elemento");
		s.add("Terzo Elemento");
		s.add("Secondo Elemento");
		
		boolean cont = s.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento': " + cont);
		
		boolean isEmp = s.isEmpty();
		log.info("List isEmpty: " + isEmp);
		
		int size = s.size();
		log.info("List size: " + size);
		
		//s.remove("Primo Elemento");
		
		s.forEach(e -> log.info(e));
		
		// Metodi che definisce SortedSet
		s.first();
		s.last();
		
	}

	public static void testQueue() {
		Queue<String> q = new LinkedList<String>();
		
		q.add("Primo Elemento");
		q.add("Secondo Elemento");
		q.add("Terzo Elemento");
		
		boolean cont = q.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento': " + cont);
		
		boolean isEmp = q.isEmpty();
		log.info("Queue isEmpty: " + isEmp);
		
		int size = q.size();
		log.info("Queue size: " + size);
		
		q.forEach(e -> log.info(e));
		
		String elePeek =  q.peek();
		log.info("Queue peek element: " + elePeek);
		
		String elePoll =  q.poll();
		log.info("Queue poll element: " + elePoll);
		
		q.forEach(e -> log.info(e));
		
		q.clear();
		
	}
	
	public static void testMap() {
		Map<String, String> m = new HashMap<String, String>();
		// non può contenere valori primitivi
		// gli oggetti non sono memorizzati in base all'ordine di inserimento
		// non eredita da Collection
		
		m.put("a", "Primo Elemento");
		m.put("b", "Secondo Elemento");
		m.put("c", "Terzo Elemento");
		
		boolean b = m.containsKey("a");
		log.info("Contains 'key: a': " + b);
		
		String ele = m.get("a");
		log.info("Map key 'a': " + ele);
		
		boolean isEmp = m.isEmpty();
		log.info("Map isEmpty: " + isEmp);
		
		int size = m.size();
		log.info("Map size: " + size);
		
		Set<String> key = m.keySet();
		key.forEach(e -> log.info(e));
		
		//m.clear();
		
		boolean v = m.containsValue("Secondo Elemento");
		log.info("Contains 'Value: Secondo Elemento': " + v);
		
		Collection<String> values = m.values();
		values.forEach(e -> log.info(e));
	}
}
