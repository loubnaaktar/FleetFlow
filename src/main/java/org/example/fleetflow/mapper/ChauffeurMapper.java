package org.example.fleetflow.mapper;

import org.example.fleetflow.DTO.ChauffeurDTO;
import org.example.fleetflow.model.Chauffeur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {

    ChauffeurMapper INSTANCE = Mappers.getMapper(ChauffeurMapper.class);

    Chauffeur toEntity(ChauffeurDTO dto);

    ChauffeurDTO toDTO(Chauffeur chauffeur);
}
