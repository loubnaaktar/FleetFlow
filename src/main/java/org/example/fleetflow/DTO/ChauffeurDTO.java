package org.example.fleetflow.DTO;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChauffeurDTO implements Serializable {
    private Long id ;
    private String nom;
    private String telephone;
    private String permisType;
    private Boolean disponible;
//    private List<Livraison> livraisons ;
}
