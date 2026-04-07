package org.example.fleetflow.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.fleetflow.model.Vehicule;

@Data
public class VehiculeDTO {
    private Long id;
    @NotBlank(message = "matricule est obligatoire")
    private String matricule;
    @NotNull(message = "type est obligatoire")
    private Vehicule.TypeVehicule type;
    @NotNull(message = "capacite est obligatoire")
    private Integer capacite;
    @NotNull(message = "le statut disponible est obligatoire")
    private Vehicule.StatutVehicule statut;
}
