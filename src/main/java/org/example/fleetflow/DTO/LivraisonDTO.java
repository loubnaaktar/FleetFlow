package org.example.fleetflow.DTO;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.fleetflow.model.Chauffeur;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LivraisonDTO {
    private long id;
    private LocalDateTime dateLivraison;
    private String adresseDepart;
    private String adresseDestination;
    private String Statut;
    private Chauffeur chauffeur;
}
