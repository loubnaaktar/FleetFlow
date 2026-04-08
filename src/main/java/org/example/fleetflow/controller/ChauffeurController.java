package org.example.fleetflow.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.fleetflow.DTO.ChauffeurDTO;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.service.ChauffeurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Valid
@RequestMapping("/api/chauffeures")

@AllArgsConstructor
public class ChauffeurController {
    private final ChauffeurService chauffeurService;
    @GetMapping
    public List<ChauffeurDTO> listChauffeuresDispo(){
        return chauffeurService.cheuffeursDisponibles();
    }

    @PostMapping("/ajouter")
        public ChauffeurDTO ajouterChauffeur(@RequestBody ChauffeurDTO chauffeurDTO){
        return chauffeurService.ajouterChauffeur(chauffeurDTO);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerChauffeur(@PathVariable long id){
        chauffeurService.supprimerChauffeur(id);
    }

  @PutMapping("/modifier/{id}")
    public ChauffeurDTO modifierChauffeur(@PathVariable long id, @RequestBody ChauffeurDTO chauffeurDTO){
       return chauffeurService.modifierChauffeur(id,chauffeurDTO);
  }


}
