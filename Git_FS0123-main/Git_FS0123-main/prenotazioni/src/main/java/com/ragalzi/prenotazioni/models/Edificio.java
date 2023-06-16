package com.ragalzi.prenotazioni.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "edifici")
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String citta;

//    Relazione bidirezionale tra edificio e postazione
//    @OneToMany (mappedBy = "edificio",)
//    private Set<Prenotazione> prenotazioni;
    
//    {
//        "nome":"Edificio1",
//       "indirizzo": "via delle case",
//       "citta":"Roma"
//    }
}
