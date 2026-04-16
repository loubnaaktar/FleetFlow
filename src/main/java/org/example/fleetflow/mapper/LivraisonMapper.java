package org.example.fleetflow.mapper;
import org.example.fleetflow.DTO.ChauffeurDTO;
import org.example.fleetflow.DTO.LivraisonDTO;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.model.Livraison;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivraisonMapper {
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "chauffeur.id", target = "chauffeurId")
    @Mapping(source = "vehicule.id", target = "vehiculeId")
    LivraisonDTO toDTO(Livraison livraison);

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "chauffeurId", target = "chauffeur.id")
    @Mapping(source = "vehiculeId", target = "vehicule.id")
    Livraison toEntity(LivraisonDTO livraisonDTO);

    List<LivraisonDTO> toDTO(List<Livraison> livraisons);
}
