package org.example.fleetflow.service;

import org.example.fleetflow.DTO.VehiculeDTO;
import org.example.fleetflow.Repository.VehiculeRepository;
import org.example.fleetflow.model.Vehicule;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class VehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;
    public VehiculeDTO createVehicule(vehiculeDTO dto){
        Vehicule vehicule = vehiculeMapper.toEntity(dto);
        Vehicule saved = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDto(saved);
    }
    public List<VehiculeDTO> getVehiculesDisponible(){
        return vehiculeRepository.findByStatut(Vehicule.StatutVehicule.DISPONIBLE)
                .stream().map(vehiculeMapper::toDto).collect(Collectors.toList());
    }
}
