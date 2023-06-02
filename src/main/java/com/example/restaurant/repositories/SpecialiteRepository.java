package com.example.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurant.entities.Specialite;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {
    // Ajoutez des méthodes spécifiques au besoin
}