package org.example.fleetflow.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ChauffeurDTO {
    long id ;
    String nom;
    String telephone;
    String permisType;
    boolean disponible;
}
