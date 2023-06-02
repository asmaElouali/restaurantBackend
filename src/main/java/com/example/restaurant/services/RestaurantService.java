package com.example.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.restaurant.entities.Restaurant;
import com.example.restaurant.entities.Specialite;
import com.example.restaurant.entities.Zone;
import com.example.restaurant.repositories.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
	private final RestaurantRepository restaurantRepository;

	@Autowired
	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	public List<Restaurant> getRestaurantsByZone(Zone zone) {
		return restaurantRepository.findByZone(zone);
	}

	public void deleteRestaurant(int id) {
		restaurantRepository.deleteById(id);
	}

	public Restaurant updateRestaurant(int id, Restaurant updatedRestaurant) {
		Optional<Restaurant> existingRestaurantOptional = restaurantRepository.findById(id);
		if (existingRestaurantOptional.isPresent()) {
			Restaurant existingRestaurant = existingRestaurantOptional.get();
			existingRestaurant.setNom(updatedRestaurant.getNom());
			existingRestaurant.setZone(updatedRestaurant.getZone());
			existingRestaurant.setSpecialites(updatedRestaurant.getSpecialites());
			// Set other properties as needed

			return restaurantRepository.save(existingRestaurant);
		} else {
			throw new IllegalArgumentException("Restaurant not found with ID: " + id);
		}
	}

	public Restaurant createRestaurant(Restaurant restaurant) {
		// Perform validation or any other necessary checks
		return restaurantRepository.save(restaurant);
	}

	public List<Restaurant> filterRestaurantsBySpecialite(Specialite specialite) {
		return restaurantRepository.findBySpecialites(specialite);
	}

	public Optional<Restaurant> getRestaurantById(int id) {
		return restaurantRepository.findById(id);
	}

	// Autres méthodes selon les besoins


}
