package org.example.fleetflow.service;

import org.example.fleetflow.DTO.LivraisonDTO;
import org.example.fleetflow.Repository.ClientRepository;
import org.example.fleetflow.Repository.LivraisonRepository;
import org.example.fleetflow.mapper.LivraisonMapper;
import org.example.fleetflow.model.Chauffeur;
import org.example.fleetflow.model.Client;
import org.example.fleetflow.model.Livraison;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LivraisonServiceTest {
    Client client ;
    LivraisonDTO livraisonDTO;
    Livraison livraison;

@Mock
    LivraisonRepository livraisonRepository;
@Mock
    LivraisonMapper livraisonMapper;
@Mock
    ClientRepository clientRepository;
@InjectMocks
    LivraisonService livraisonService;


    @BeforeEach
    void initialisation(){
      livraison = new Livraison();
      livraisonDTO = new LivraisonDTO();
    }
    @Test
    void ajouterLivraison() {
 client = new Client(1L);
Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.ofNullable(client));
Mockito.when(livraisonMapper.toEntity(livraisonDTO)).thenReturn(livraison);
LivraisonDTO livr = livraisonService.ajouterLivraison(1L,livraisonDTO);
Mockito.when(livraisonRepository.save(Mockito.any())).thenReturn(livraison);
assertEquals(Livraison.StatutLivraison.ENATTENTE.name(),livr.getStatut());
    }
}