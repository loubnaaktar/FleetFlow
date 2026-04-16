package org.example.fleetflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String matricule;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "le type est obligatoire")
    private TypeVehicule type;

    private Integer   capacite;

   @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "le statut est obligatoire")
    private StatutVehicule statut= StatutVehicule.DISPONIBLE;

   public enum TypeVehicule{
       CAMION,FOURGON,CAMIONETTE
   }
   public enum StatutVehicule{
       DISPONIBLE,EN_LIVRAISON,MAINTENANCE
   }
}
