package com.example.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.restaurant.entities.Specialite;
import com.example.restaurant.services.SpecialiteService;

import java.util.List;

@RestController
@RequestMapping("/specialites")
@CrossOrigin
public class SpecialiteController {
    private final SpecialiteService specialiteService;

    @Autowired
    public SpecialiteController(SpecialiteService specialiteService) {
        this.specialiteService = specialiteService;
    }

    @PostMapping
    public Specialite createSpecialite(@RequestBody Specialite specialite) {
        return specialiteService.createSpecialite(specialite);
    }

    @PutMapping("/{id}")
    public Specialite updateSpecialite(@PathVariable int id, @RequestBody Specialite specialite) {
        return specialiteService.updateSpecialite(id, specialite);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialite(@PathVariable int id) {
        specialiteService.deleteSpecialite(id);
    }

    @GetMapping
    public List<Specialite> getAllSpecialites() {
        return specialiteService.getAllSpecialites();
    }

    @GetMapping("/{id}")
    public Specialite getSpecialiteById(@PathVariable int id) {
        return specialiteService.getSpecialiteById(id);
    }
}