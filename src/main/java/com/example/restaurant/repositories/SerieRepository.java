package com.example.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurant.entities.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
    
}
