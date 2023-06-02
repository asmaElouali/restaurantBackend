package com.example.restaurant.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Zone;
    private String nom_Zone;

    @OneToMany(mappedBy = "zone", fetch = FetchType.LAZY)
    private List<Restaurant> restaurants;
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ville_id")
    private Ville ville;

    public Zone() {
        super();
    }

    public int getId_Zone() {
        return id_Zone;
    }

    public void setId_Zone(int id_Zone) {
        this.id_Zone = id_Zone;
    }

    public String getNom_Zone() {
        return nom_Zone;
    }

    public void setNom_Zone(String nom_Zone) {
        this.nom_Zone = nom_Zone;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
    
}