package com.example.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.restaurant.entities.Restaurant;
import com.example.restaurant.entities.Specialite;
import com.example.restaurant.entities.Zone;
import com.example.restaurant.services.RestaurantService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/zone/{zoneId}")
    public List<Restaurant> getRestaurantsByZone(@PathVariable int zoneId) {
        Zone zone = new Zone();
        zone.setId_Zone(zoneId);
        return restaurantService.getRestaurantsByZone(zone);
    }

    @GetMapping("/specialite/{specialiteId}")
    public List<Restaurant> filterRestaurantsBySpecialite(@PathVariable int specialiteId) {
        Specialite specialite = new Specialite();
        specialite.setId(specialiteId);
        return restaurantService.filterRestaurantsBySpecialite(specialite);
    }
    
    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable int id) {
        return restaurantService.getRestaurantById(id);
    }

    // Autres méthodes selon les besoins
    
    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable int id, @RequestBody Restaurant updatedRestaurant) {
        return restaurantService.updateRestaurant(id, updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteRestaurant(id);
    }
    
    
    
}
