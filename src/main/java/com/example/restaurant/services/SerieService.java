package com.example.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.entities.Serie;
import com.example.restaurant.repositories.SerieRepository;

import java.util.List;

@Service
public class SerieService {
    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public Serie createSerie(Serie serie) {
        // Implémentez la logique de création de la série
        // Vous pouvez appeler les méthodes appropriées du repository
        return serieRepository.save(serie);
    }

    public Serie updateSerie(int id, Serie updatedSerie) {
        // Implémentez la logique de mise à jour de la série par son identifiant
        Serie existingSerie = serieRepository.findById(id).orElse(null);
        if (existingSerie != null) {
            existingSerie.setNom(updatedSerie.getNom());
            return serieRepository.save(existingSerie);
        }
        return null;
    }

    public void deleteSerie(int id) {
        // Implémentez la logique de suppression de la série par son identifiant
        serieRepository.deleteById(id);
    }

    public List<Serie> getAllSeries() {
        // Implémentez la logique pour obtenir toutes les séries
        return serieRepository.findAll();
    }

    public Serie getSerieById(int id) {
        // Implémentez la logique pour obtenir une série par son identifiant
        return serieRepository.findById(id).orElse(null);
    }
}
