package org.example.fleetflow.service;

import lombok.RequiredArgsConstructor;
import org.example.fleetflow.DTO.VehiculeDTO;
import org.example.fleetflow.Repository.VehiculeRepository;
import org.example.fleetflow.mapper.VehiculeMapper;
import org.example.fleetflow.model.Vehicule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    public VehiculeDTO createVehicule(VehiculeDTO dto){
        Vehicule vehicule = vehiculeMapper.toEntity(dto);
        Vehicule saved = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDto(saved);
    }
    public List<VehiculeDTO> getVehiculesDisponible(){
        return vehiculeRepository.findByStatut(Vehicule.StatutVehicule.DISPONIBLE)
                .stream().map(vehiculeMapper::toDto).collect(Collectors.toList());
    }

    public List<VehiculeDTO> getAll(){
        return vehiculeRepository.findAll().stream().map(vehiculeMapper::toDto)
                .collect(Collectors.toList());
    }

    public VehiculeDTO getById(Long id){
        Vehicule vehicule = VehiculeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("vehicule introuvable"));
        return VehiculeMapper.toDto(vehicule);
    }

    public VehiculeDTO update(Long id ,VehiculeDTO dto){
        Vehicule vehicule = VehiculeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("vehicule introuvable"));
        VehiculeMapper.updateEntityFromDto(vehicule,dto);
        return VehiculeMapper.toDto(VehiculeRepository.save(vehicule));
    }
    public VehiculeDTO delete(Long id){
        return VehiculeRepository.deleteById(id);
    }

}
