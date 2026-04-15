package org.example.fleetflow.service;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDateTime;
import java.util.Optional;

import static org.example.fleetflow.model.Vehicule.StatutVehicule.DISPONIBLE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LivraisonServiceTest {

@Mock
    LivraisonRepository livraisonRepository;
@Mock
    LivraisonMapper livraisonMapper;
@Mock
    ClientRepository clientRepository;
@Mock
    ChauffeurRepository chauffeurRepository;
@Mock
    VehiculeRepository vehiculeRepository;
@InjectMocks
    LivraisonService livraisonService;



    @Test
    void ajouterLivraison() {
        Client client = new Client();
        client.setId(1L);
        client.setNom("Salma");

        Livraison livraison = new Livraison();
//        livraison.setDateLivraison(LocalDateTime.now());
//        livraison.setAdresseDepart("BM");
//        livraison.setAdresseDestination("Rabat");

        LivraisonDTO livraisonDTO = new LivraisonDTO();
        livraisonDTO.setDateLivraison(LocalDateTime.now());
        livraisonDTO.setAdresseDepart("BM");
        livraisonDTO.setAdresseDestination("Rabat");
        livraisonDTO.setClient(client);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(livraisonRepository.save(livraison)).thenReturn(new Livraison());
        when(livraisonMapper.toDTO(livraison)).thenReturn(livraisonDTO);

        LivraisonDTO resultat = livraisonService.ajouterLivraison(1L,livraisonDTO);
        assertEquals(Livraison.StatutLivraison.ENATTENTE,resultat.getStatut());
    }


//    @Test
//    void ajouterLivraison() {
//
//        Client client = new Client();
//        client.setId(1L);
//        when(clientRepository.findById(1L))
//                .thenReturn(Optional.of(client));
//
//        LivraisonDTO savedLivraison = new LivraisonDTO();
//        savedLivraison.setAdresseDepart("BM");
//        savedLivraison.setAdresseDestination("Rabat");
//        savedLivraison.setClient(client);
//
////        savedLivraison.setStatut(Livraison.StatutLivraison.ENATTENTE);
//    Livraison liv = livraisonMapper.toEntity(savedLivraison);
//        when(livraisonRepository.save(any(Livraison.class)))
//                .thenReturn(liv);
////
//        when(livraisonMapper.toDTO(any(Livraison.class)))
//                .thenReturn(savedLivraison);
//
//        LivraisonDTO result = livraisonService.ajouterLivraison(1L,savedLivraison);
//
////        assertNotNull(result);
//        assertEquals(Livraison.StatutLivraison.ENATTENTE.name(),result.getStatut());
//    }

    @Test
    void assignerChauffeurVehicule() {
        Livraison livraison = new Livraison();
        livraison.setId(1L);

        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setId(2L);
        chauffeur.setNom("ahmed");
        chauffeur.setDisponible(true);

        Vehicule vehicule = new Vehicule();
        vehicule.setId(3L);
        vehicule.setMatricule("AB28");
        vehicule.setStatut(Vehicule.StatutVehicule.DISPONIBLE);

        LivraisonDTO livraisonDTO = new LivraisonDTO();
        livraisonDTO.setId(1L);
        livraisonDTO.setChauffeur(chauffeur);
        livraisonDTO.setVehicule(vehicule);

        when(chauffeurRepository.findById(2L)).thenReturn(Optional.of(chauffeur));
        when(vehiculeRepository.findById(3L)).thenReturn(Optional.of(vehicule));
        when(livraisonRepository.findById(1L)).thenReturn(Optional.of(livraison));
        when(livraisonRepository.save(livraison)).thenReturn(livraison);
        when(livraisonMapper.toDTO(livraison)).thenReturn(livraisonDTO);

        LivraisonDTO resultat = livraisonService.assignerChauffeurVehicule(1L,2L,3L);

        assertEquals("ahmed",resultat.getChauffeur().getNom());

    }
}