package com.example.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.entities.Specialite;
import com.example.restaurant.repositories.SpecialiteRepository;

import java.util.List;

@Service
public class SpecialiteService {
    private final SpecialiteRepository specialiteRepository;

    @Autowired
    public SpecialiteService(SpecialiteRepository specialiteRepository) {
        this.specialiteRepository = specialiteRepository;
    }

    public Specialite createSpecialite(Specialite specialite) {
        // Implémentez la logique de création de la spécialité
        // Vous pouvez appeler les méthodes appropriées du repository
        return specialiteRepository.save(specialite);
    }

    public Specialite updateSpecialite(int id, Specialite updatedSpecialite) {
        // Implémentez la logique de mise à jour de la spécialité par son identifiant
        Specialite existingSpecialite = specialiteRepository.findById(id).orElse(null);
        if (existingSpecialite != null) {
            existingSpecialite.setNom(updatedSpecialite.getNom());
            return specialiteRepository.save(existingSpecialite);
        }
        return null;
    }

    public void deleteSpecialite(int id) {
        // Implémentez la logique de suppression de la spécialité par son identifiant
        specialiteRepository.deleteById(id);
    }

    public List<Specialite> getAllSpecialites() {
        // Implémentez la logique pour obtenir toutes les spécialités
        return specialiteRepository.findAll();
    }

    public Specialite getSpecialiteById(int id) {
        // Implémentez la logique pour obtenir une spécialité par son identifiant
        return specialiteRepository.findById(id).orElse(null);
    }
}