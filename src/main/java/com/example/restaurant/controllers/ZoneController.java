package com.example.restaurant.controllers;
import com.example.restaurant.entities.Ville;
import com.example.restaurant.entities.Zone;
import com.example.restaurant.services.ZoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
@CrossOrigin
public class ZoneController {
    private final ZoneService zoneService;

    @Autowired
    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping
    public List<Zone> getAllZones() {
        return zoneService.getAllZones();
    }

    @GetMapping("/{id}")
    public Zone getZoneById(@PathVariable int id) {
        return zoneService.getZoneById(id);
    }

    @GetMapping("/by-ville/{villeId}")
    public List<Zone> getZonesByVilleId(@PathVariable int villeId) {
        return zoneService.getZonesByVilleId(villeId);
    }

    @PostMapping("/by-ville/{villeId}")
    public Zone createZone(@PathVariable int villeId, @RequestBody Zone zone) {
        return zoneService.createZone(villeId, zone);
    }

    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable int id, @RequestBody Zone zone) {
        return zoneService.updateZone(id, zone);
    }

    @DeleteMapping("/{id}")
    public void deleteZone(@PathVariable int id) {
        zoneService.deleteZone(id);
    }
    
    @GetMapping("/{zoneId}/ville")
    public Ville getVilleByZoneId(@PathVariable int zoneId) {
        return zoneService.getVilleByZoneId(zoneId);
    }
}