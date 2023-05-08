package com.epicode.project;

import com.epicode.project.classes.Automobile;
import com.epicode.project.classes.Camper;
import com.epicode.project.classes.Moto;
import com.epicode.project.classes.Smartphone;
import com.epicode.project.classes.Veicolo;
import com.epicode.project.interfaces.Navigatore;

public class MainProject {

	public static void main(String[] args) {
		
		//Veicolo v1 = new Veicolo(); -> Classe Abstract
		Automobile a1 = new Automobile("Fiat", "500", 3);
		Automobile a2 = new Automobile("d", "Kuga", 5);
		Moto m1 = new Moto("Honda", "Hornet", 1);
		Moto m2 = new Moto("Ducati", "Monster", 2);
		Camper c1 = new Camper("Mobilvetta", "fs0123", 5);
		Camper c2 = new Camper("McLouis", "abc12", 7);
		Smartphone s1 = new Smartphone("Apple", "Iphone", 64, "IOS");
		Smartphone s2 = new Smartphone("Samsung", "Galaxy", 128, "Android");
		
//		Automobile[] grageAuto = {a1, a2};
//		Moto[] grageMoto = {m1, m2};
//		Camper[] grageCamper = {c1, c2};
		
		Veicolo[]garage = {a1, a2, m1, m2, c1, c2};
		
		for (Veicolo veicolo : garage) {
			if(veicolo instanceof Automobile) {
				// fai qualcosa
			} else  if(veicolo instanceof Moto) {
				// fai qualcosa
			} else if(veicolo instanceof Camper) {
				// fai qualcosa
			}
			System.out.println(veicolo);
		}
		
		Navigatore[] oggConNavigatore = {a1, c1, s1};
		
		for (Navigatore ogg : oggConNavigatore) {
			ogg.aggiornaNavigatore();
		}
		
		
		String[] arr = new String[5];
		arr[5] = "ciao";
		
		String str = null;
		System.out.println(str.charAt(0));

	}

}
