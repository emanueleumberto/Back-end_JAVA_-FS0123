package com.epicode.oop;

public class MainProject {

	public static void main(String[] args) {
		
		//Veicolo v = new Veicolo("Bmw", "X5");
		Automobile v1 = new Automobile("Fiat", "500", 3);
		Automobile v2 = new Automobile("Ford", "Fiesta", 5);
		Veicolo v3 = new Automobile("Bmw", "X5", 5);
		Moto m1 = new Moto("Honda", "Hornet", 1000);
		Veicolo v4 = new Moto("Ducati", "900", 900);
		Smartphone s1 = new Smartphone("Apple", "Iphone");
		
		Veicolo v = v1;
		Automobile auto = (Automobile) v;
		
		Navigatore[] ogg = new Navigatore[5];
		ogg[0] = v1;
		ogg[1] = s1;
		
		for (int i = 0; i < ogg.length; i++) {
			ogg[i].aggiornaNavigatore();
		}

		
		Veicolo[] arr = new Veicolo[5];
		arr[0] = v1; // 
		arr[1] = m1;
		arr[2] = v3;
		arr[3] = v4;
		arr[4] = v2;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] instanceof Automobile) {
				Automobile a = (Automobile) arr[i];
				a.start();
				//a.test();
			} else if(arr[i] instanceof Moto) {
				Moto a = (Moto) arr[i];
				a.start();
				//a.test();
			}
			arr[i].test();
		}
		
		//System.out.println(v1);
		//System.out.println(v2);

		//Veicolo.veicoliCreati();
		
		//v1.test(GiornoSettimana.MARTEDI);
		
		GiornoSettimana giornoSettimana = GiornoSettimana.VENERDI;
		//System.out.println(giornoSettimana);

	}

}
