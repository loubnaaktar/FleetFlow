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
    private TypeVehicule type;
    private Integer   capacite;
   @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutVehicule statut= StatutVehicule.DISPONIBLE;
    @NotNull(message = "le type disponible est obligatoire")
   public enum TypeVehicule{
       CAMION,FOURGON,CAMIONETTE
   }
   @NotNull(message = "le statut disponible est obligatoire")
   public enum StatutVehicule{
       DISPONIBLE,EN_LIVRAISON,MAINTENANCE
   }
}
