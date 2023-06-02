package com.example.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.restaurant.entities.Serie;
import com.example.restaurant.services.SerieService;

import java.util.List;

@RestController
@RequestMapping("/series")
@CrossOrigin
public class SerieController {
    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping
    public Serie createSerie(@RequestBody Serie serie) {
        return serieService.createSerie(serie);
    }

    @PutMapping("/{id}")
    public Serie updateSerie(@PathVariable int id, @RequestBody Serie serie) {
        return serieService.updateSerie(id, serie);
    }

    @DeleteMapping("/{id}")
    public void deleteSerie(@PathVariable int id) {
        serieService.deleteSerie(id);
    }

    @GetMapping
    public List<Serie> getAllSeries() {
        return serieService.getAllSeries();
    }

    @GetMapping("/{id}")
    public Serie getSerieById(@PathVariable int id) {
        return serieService.getSerieById(id);
    }
}
