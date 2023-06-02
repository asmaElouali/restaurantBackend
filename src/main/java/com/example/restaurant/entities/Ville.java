package com.example.restaurant.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ville")
	private int id;
	private String nom_Ville;
    
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "ville")
	private List<Zone> zones;

	public Ville() {
		super();
	}

	public int getId_Ville() {
		return id;
	}

	public void setId_Ville(int id_Ville) {
		this.id = id_Ville;
	}

	public String getNom_Ville() {
		return nom_Ville;
	}

	public void setNom_Ville(String nom_Ville) {
		this.nom_Ville = nom_Ville;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}
}