package org.example.fleetflow.service;

import lombok.AllArgsConstructor;
import org.example.fleetflow.DTO.ChauffeurDTO;
import org.example.fleetflow.Repository.ChauffeurRepository;
import org.example.fleetflow.model.Chauffeur;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChauffeurService {
private final ChauffeurRepository chauffeurRepository;

public Chauffeur ajouterChauffeur(ChauffeurDTO chauffeurDTO){
    return chauffeurRepository.save(chauffeurDTO);
}


}
