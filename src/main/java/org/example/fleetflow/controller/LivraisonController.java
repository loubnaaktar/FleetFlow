package org.example.fleetflow.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.fleetflow.DTO.LivraisonDTO;
import org.example.fleetflow.DTO.VehiculeDTO;
import org.example.fleetflow.model.Livraison;
import org.example.fleetflow.service.LivraisonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livraison")
@RequiredArgsConstructor
public class LivraisonController {

    private final LivraisonService livraisonService;

    @PostMapping
    public LivraisonDTO create(@Valid @RequestParam Long idClient, @RequestBody LivraisonDTO dto) {
        return livraisonService.ajouterLivraison(idClient, dto);
    }

    @PutMapping("/{id}/assigner")
    public LivraisonDTO assigner(@Valid
                                 @PathVariable Long id,
                                 @RequestParam Long idChauffeur,
                                 @RequestParam Long idVehicule){

        return livraisonService.assignerChauffeurVehicule(id, idChauffeur, idVehicule);
    }

    @GetMapping
    public List<LivraisonDTO> getAll(){
        return livraisonService.listLivraisons();
    }

    @PutMapping("/{id}/statut")
    public LivraisonDTO updateStatut(@Valid
                                     @PathVariable Long id,
                                     @RequestParam Livraison.StatutLivraison statut){
        return livraisonService.modifierStatutLivraison(id, statut);
    }
}