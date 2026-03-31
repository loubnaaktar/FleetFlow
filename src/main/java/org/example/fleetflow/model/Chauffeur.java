package org.example.fleetflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chaffeur")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Chauffeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nom;
    String telephone;
    String permisType;
    boolean disponible;

}
