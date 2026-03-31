package org.example.fleetflow.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.fleetflow.model.Livraison;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ChauffeurDTO {
    private long id ;
    private String nom;
    private String telephone;
    private String permisType;
    private boolean disponible;
    private List<Livraison> livraisons ;
}
