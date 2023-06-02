package com.example.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurant.entities.Restaurant;
import com.example.restaurant.entities.Specialite;
import com.example.restaurant.entities.Zone;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findByZone(Zone zone);
    
    List<Restaurant> findBySpecialites(Specialite specialite);

    // Autres méthodes selon les besoins
}
