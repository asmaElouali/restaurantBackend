package com.example.restaurant.controllers;

import com.example.restaurant.entities.Ville;
import com.example.restaurant.services.VilleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
@CrossOrigin
public class VilleController {
    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping
    public List<Ville> getAllVilles() {
        return villeService.getAllVilles();
    }

    @GetMapping("/{id}")
    public Ville getVilleById(@PathVariable int id) {
        return villeService.getVilleById(id);
    }

    @PostMapping
    public Ville createVille(@RequestBody Ville ville) {
        return villeService.createVille(ville);
    }

    @PutMapping("/{id}")
    public Ville updateVille(@PathVariable int id, @RequestBody Ville ville) {
        return villeService.updateVille(id, ville);
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable int id) {
        villeService.deleteVille(id);
    }
}