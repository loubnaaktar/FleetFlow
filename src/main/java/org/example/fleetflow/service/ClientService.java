package org.example.fleetflow.service;

import org.example.fleetflow.DTO.ClientDTO;
import org.example.fleetflow.Repository.ClientRepository;
import org.example.fleetflow.mapper.ClientMapper;
import org.example.fleetflow.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper mapper;

    public ClientDTO addClient(ClientDTO clientDTO) {
        return mapper.toDTO(clientRepository.save(mapper.toEntity(clientDTO)));
    }


    public List<ClientDTO> getAllClients() {
        return mapper.toDTOList( clientRepository.findAll());
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







