package com.example.restaurant.entities;


import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String adresse;
    private double latitude;
    private double longitude;
    private int rank;

    
    @Temporal(TemporalType.TIME)
    private LocalTime heure_open;
    
    @Temporal(TemporalType.TIME)
    private LocalTime heure_close;
    
    private String week;
    
    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;
    
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToMany(mappedBy = "restaurants", fetch = FetchType.EAGER)
    private List<Specialite> specialites;
    
    @OneToMany(mappedBy = "restaurant")
    private List<Photo> photos;
    
    @OneToMany(mappedBy = "restaurant")
    private List<User> users;

    public Restaurant() {
        super();
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public LocalTime getHeure_open() {
        return heure_open;
    }

    public void setHeure_open(LocalTime heure_open) {
        this.heure_open = heure_open;
    }

    public LocalTime getHeure_close() {
        return heure_close;
    }

    public void setHeure_close(LocalTime heure_close) {
        this.heure_close = heure_close;
    }

    public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public List<Specialite> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(List<Specialite> specialites) {
    	this.specialites =specialites;
    }
}