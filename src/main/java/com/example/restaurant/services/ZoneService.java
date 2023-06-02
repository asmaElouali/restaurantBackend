package com.example.restaurant.services;

import com.example.restaurant.entities.Ville;
import com.example.restaurant.entities.Zone;
import com.example.restaurant.repositories.VilleRepository;
import com.example.restaurant.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {
    private final ZoneRepository zoneRepository;
    private final VilleRepository villeRepository;

    @Autowired
    public ZoneService(ZoneRepository zoneRepository,VilleRepository villeRepository) {
        this.zoneRepository = zoneRepository;
        this.villeRepository=villeRepository;
    }

    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    public Zone getZoneById(int id) {
        return zoneRepository.findById(id).orElse(null);
    }

    public List<Zone> getZonesByVilleId(int villeId) {
        return zoneRepository.findByVilleId(villeId);
    }

    public Zone createZone(Integer villeId, Zone zone) {
        Ville ville = villeRepository.findById(villeId).orElse(null);
        if (ville != null) {
            zone.setVille(ville);
            return zoneRepository.save(zone);
        }
        return null;
    }

    public Zone updateZone(int id, Zone zone) {
        Zone existingZone = zoneRepository.findById(id).orElse(null);
        if (existingZone != null) {
            existingZone.setNom_Zone(zone.getNom_Zone());
            return zoneRepository.save(existingZone);
        }
        return null;
    }

    public void deleteZone(int id) {
        zoneRepository.deleteById(id);
    }

    public Ville getVilleByZoneId(int zoneId) {
        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        if (zone != null) {
            return zone.getVille();
        }
        return null;
    }
}