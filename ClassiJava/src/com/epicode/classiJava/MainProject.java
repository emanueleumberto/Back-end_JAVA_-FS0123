package com.epicode.classiJava;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Veicolo v1 = new Veicolo();
		v1.marca = "Fiat";
		v1.modello = "Panda";
		v1.printInfo();
		System.out.println(v1.type);
		
		v1.type = "Camper";
		
		Veicolo v1b = new Veicolo();
		v1b.marca = "Smart";
		v1b.modello = "x2";
		v1b.printInfo();
		System.out.println(v1b.type);
		
		Veicolo v2 = new Veicolo("Ford", "Fiesta");
		Veicolo v3 = new Veicolo("Ford", "Fiesta");
		Veicolo v4 = v2;
		v4.marca = "Mercedes";
		System.out.println(v4.type);
		
		System.out.println(v2.marca);
		System.out.println(v3);
		System.out.println(v4.marca);
		
		v4.numVeicoli();
		
		Veicolo.numVeicoli();
		
		
		Veicolo v5 = new Veicolo("Ford", "Fiesta");
		Veicolo v6 = new Veicolo("Ford", "Fiesta");
		Veicolo v7 = v5;
		
		System.out.println(v5);
		System.out.println(v6);
		System.out.println(v7);
		//System.out.println(v5 == v6); ERRORE
		System.out.println(v5.equals(v6));
		//System.out.println(v5 == v7); ERRORE
		System.out.println(v5.equals(v7));
		
		int x = 25;
		int y = x;
		y++;
		System.out.println(x);
		System.out.println(y);
		
		String st = "ciao";
		String stc = st;
		stc  = "aslfj";
		System.out.println(st);
		System.out.println(stc);
		
		System.out.println(x);
		modNum(x);
		System.out.println(x);
		
		System.out.println(v5.marca);
		modVeicolo(v5);
		System.out.println(v5.marca);
	}
	
	public static void modNum(int n) {
		n = 40;
	}
	
	public static void modVeicolo(Veicolo v) {
		v.marca = "XXXX";
	}
	

}
