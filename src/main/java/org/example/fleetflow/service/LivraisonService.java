package org.example.fleetflow.service;

import lombok.AllArgsConstructor;
import org.example.fleetflow.DTO.LivraisonDTO;
import org.example.fleetflow.Repository.ChauffeurRepository;
import org.example.fleetflow.Repository.ClientRepository;
import org.example.fleetflow.Repository.LivraisonRepository;
import org.example.fleetflow.Repository.VehiculeRepository;
import org.example.fleetflow.mapper.LivraisonMapper;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.model.Client;
import org.example.fleetflow.model.Livraison;
import org.example.fleetflow.model.Vehicule;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.fleetflow.model.Vehicule.StatutVehicule.EN_LIVRAISON;

@Service
@AllArgsConstructor
public class LivraisonService {
    private final LivraisonRepository livraisonRepository;
    private final ClientRepository clientRepository;
    private final LivraisonMapper livraisonMapper;
    private final ChauffeurRepository chauffeurRepository;
    private final VehiculeRepository vehiculeRepository;

public LivraisonDTO ajouterLivraison(long idClient){
Client client = clientRepository.findById(idClient).orElse(null);
Livraison livraison = new Livraison();
livraison.setClient(client);
Livraison livr = livraisonRepository.save(livraison);
return livraisonMapper.toDTO(livr);
}


public LivraisonDTO assignerChauffeurVehicule(long idLivraison, long idChauffeur, long idVehicule){
Livraison livraison = livraisonRepository.findById(idLivraison).orElseThrow(() ->new RuntimeException("Livraison introuvable"));
Chauffeur chauffeur = chauffeurRepository.findById(idChauffeur).orElseThrow(()-> new RuntimeException("chauffeur introuvable"));
Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElseThrow(() -> new RuntimeException("vehicule introuvable"));

if(!chauffeur.isDisponible()){
    throw new RuntimeException("aucun chauffeur est dispo");
}
if(!vehicule.getStatut().equals("disponible")){
    throw new RuntimeException("aucune vehicule est dispo");
}
livraison.setChauffeur(chauffeur);
livraison.setVehicule(vehicule);

chauffeur.setDisponible(false);
vehicule.setStatut(EN_LIVRAISON);

Livraison liv = livraisonRepository.save(livraison);
return livraisonMapper.toDTO(liv);
}

public List<LivraisonDTO> listLivraisons(){
List<Livraison> listLivraisons = livraisonRepository.findAll();
return livraisonMapper.toDTO(listLivraisons);
}

public LivraisonDTO modifierStatutLivraison(long idLivraison, Livraison.StatutLivraison statut){
    Livraison livraison = livraisonRepository.findById(idLivraison).orElseThrow(() ->new RuntimeException("Livraison introuvable"));
    livraison.setStatut(statut);
    Livraison liv = livraisonRepository.save(livraison);
    return livraisonMapper.toDTO(liv);
}
}
