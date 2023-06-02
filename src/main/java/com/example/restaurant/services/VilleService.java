package com.example.restaurant.services;

import com.example.restaurant.entities.Ville;
import com.example.restaurant.repositories.VilleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    private final VilleRepository villeRepository;

    @Autowired
    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public List<Ville> getAllVilles() {
        return villeRepository.findAll();
    }

    public Ville getVilleById(int id) {
        return villeRepository.findById(id).orElse(null);
    }

    public Ville createVille(Ville ville) {
        return villeRepository.save(ville);
    }

    public Ville updateVille(int id, Ville ville) {
        Ville existingVille = villeRepository.findById(id).orElse(null);
        if (existingVille != null) {
            existingVille.setNom_Ville(ville.getNom_Ville());
            //existingVille.setZones(ville.getZones());
            return villeRepository.save(existingVille);
        }
        return null;
    }

    public void deleteVille(int id) {
        villeRepository.deleteById(id);
    }
}