package Esercizio3;

import java.time.LocalDate;

public class Cliente {
	
	public String codiceCliente;
	public String nomeCognome;
	public String email;
	public LocalDate dataIscrizione;
	
	public Cliente(String codiceCliente, String nomeCognome, String email) {
		this.codiceCliente = codiceCliente;
		this.nomeCognome = nomeCognome;
		this.email = email;
		this.dataIscrizione = LocalDate.now();
	}

}
