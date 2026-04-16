package org.example.fleetflow.DTO;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.model.Client;
import org.example.fleetflow.model.Livraison;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LivraisonDTO {

    private Long id;
    private LocalDateTime dateLivraison;

    @NotBlank(message = "L'adresse de départ est obligatoire")
    private String adresseDepart;

    @NotBlank(message = "L'adresse de destination est obligatoire")
    private String adresseDestination;

    @NotNull(message = "Le statut est obligatoire")
    private Livraison.StatutLivraison statut;

    private Long clientId;
    private Long chauffeurId;
    private Long vehiculeId;
}
