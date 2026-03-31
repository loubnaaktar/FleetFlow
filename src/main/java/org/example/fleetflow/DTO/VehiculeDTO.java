package org.example.fleetflow.DTO;

import lombok.Data;
import org.example.fleetflow.model.Vehicule;

@Data
public class VehiculeDTO {
    private Long id;
    private String matricule;
    private Vehicule.TypeVehicule type;
    private Integer capacite;
    private Vehicule.StatutVehicule statut;
}
