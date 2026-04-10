package org.example.fleetflow.service;

import org.example.fleetflow.DTO.ClientDTO;
import org.example.fleetflow.Repository.ClientRepository;
import org.example.fleetflow.Repository.LivraisonRepository;
import org.example.fleetflow.mapper.ClientMapper;
import org.example.fleetflow.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;
    private LivraisonRepository livraisonRepository;
    @Autowired
    private ClientMapper mapper;

    public ClientService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    public ClientDTO addClient(ClientDTO clientDTO) {
        return mapper.toDTO(clientRepository.save(mapper.toEntity(clientDTO)));
    }


    public List<ClientDTO> getAllClients() {

        List<Client>  clients = clientRepository.findAll();
        List<ClientDTO> dtos = new ArrayList<>();

        for(Client c : clients){

            Long nombre= livraisonRepository.countLivraisonByClientId(c.getId());
         ClientDTO  dto = mapper.toDTO(c);
         dto.setNombre(nombre);
            dtos.add(dto);
        }

        return dtos;

    }


    public ClientDTO Modifierclient(Long id,ClientDTO clientDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Client " + id + " n'existe pas"));
        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());
        client.setVille(clientDTO.getVille());
        client.setTelephone(clientDTO.getTelephone());
        return mapper.toDTO(clientRepository.save(client));
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


}







