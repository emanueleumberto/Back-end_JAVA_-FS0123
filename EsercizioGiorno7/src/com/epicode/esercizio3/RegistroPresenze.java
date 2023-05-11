package com.epicode.esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroPresenze {
	
	private static List<Presenza> listaPresenze = new ArrayList<Presenza>();
	private static String path = "dati/presenze.txt";
	private static File file = new File(path);
	
	
	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(RegistroPresenze.class);

		try {
			//creaPresenze();
			//salvaPresenzeSuFile();
			leggiPresenzeDaFile();
		} catch (IOException e) {
			log.error("Errore IO file " + e.getMessage());
			e.printStackTrace();
		}
		
		listaPresenze.forEach(p -> {
			System.out.println(p);
		});

	}
	
	public static void creaPresenze() {
		listaPresenze.add(new Presenza("Mario Rossi", 5));
		listaPresenze.add(new Presenza("Giuseppe Verdi", 9));
		listaPresenze.add(new Presenza("Francesca Neri", 7));
	}
	
	public static void salvaPresenzeSuFile() throws IOException {
		String presenzeTxt = "";
		for (Presenza presenza : listaPresenze) {
			if(presenzeTxt.length() != 0) {
				presenzeTxt += "#";
			}
			presenzeTxt += presenza;
		}
		FileUtils.writeStringToFile(file, presenzeTxt, "UTF-8");
	}
	
	public static void leggiPresenzeDaFile() throws IOException {
		String presenzeTxt = FileUtils.readFileToString(file, "UTF-8");
		String[] arr = presenzeTxt.split("#");
		//System.out.println(presenzeTxt);
		for (int i = 0; i < arr.length; i++) {
			//System.out.println("indice: " + i + " Valore: " + arr[i]);
			String[] arrPersona = arr[i].split("@");
			Presenza p = new Presenza(arrPersona[0], Integer.parseInt(arrPersona[1]));
			listaPresenze.add(p);
		}
	}

}
