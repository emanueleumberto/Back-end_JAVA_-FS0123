package com.ragalzi.prenotazioni.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrenotazioneDTO {

	private LocalDate dataPrenotazione;
	private String username;
	private Postazione postazione;

//	{"dataPrenotazione":"2023-06-15",
//		"username":"francescaneri",
//	"postazione":{
//	    "id": 2,
//	    "descrizione": "partita di calcetto",
//	    "tipo": "PRIVATO",
//	    "numMaxOccupanti": 80,
//	    "edificio": {
//	        "id": 2,
//	        "nome": "Manzoni",
//	        "indirizzo": "Via Marconi 43",
//	        "citta": "Roma"
//	    }
//	}
//	}
}
