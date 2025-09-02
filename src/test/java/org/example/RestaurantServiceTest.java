package org.example;

import org.example.model.MenuItem;
import org.example.model.Restaurant;
import org.example.repository.RestaurantRepository;
import org.example.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    void createRestaurant_ReturnsSavedRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Testaurant");

        Restaurant saved = restaurantService.createRestaurant(restaurant);

        assertNotNull(saved.getId());
        assertEquals("Testaurant", saved.getName());
    }

    @Test
    void getRestaurantById_ReturnsRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("FindMe");
        restaurant = restaurantRepository.save(restaurant);

        Restaurant found = restaurantService.getRestaurantById(restaurant.getId());

        assertEquals(restaurant.getId(), found.getId());
        assertEquals("FindMe", found.getName());
    }

    @Test
    void addMenuItem_AddsItemToRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("With Menu");
        restaurant = restaurantService.createRestaurant(restaurant);

        MenuItem item = new MenuItem();
        item.setName("Pasta");
        item.setPrice(12.5);
        item.setAvailable(true);

        Restaurant updated = restaurantService.addMenuItem(restaurant.getId(), item);

        assertEquals(1, updated.getMenu().size());
        assertEquals("Pasta", updated.getMenu().get(0).getName());
    }
}
