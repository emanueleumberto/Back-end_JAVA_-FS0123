package com.ragalzi.prenotazioni.models;

import com.ragalzi.prenotazioni.enumerates.PostazioneType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "postazioni")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private PostazioneType tipo;

    private int numMaxOccupanti;

    @ManyToOne
    private Edificio edificio;
    
//    {
//        "descrizione" : "partita di calcetto",
//        "tipo" : "PRIVATO",
//        "numMaxOccupanti" : 80,
//        "edificio" : {
//        "id": 1,
//        "nome": "Manzoni",
//        "indirizzo": "Via Marconi 43",
//        "citta": "Roma"
//    }
//    }
}
