package org.example.controller;

import org.example.model.MenuItem;
import org.example.model.Restaurant;
import org.example.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurant));
    }

    @PostMapping("/{restaurantId}/menu")
    public ResponseEntity<Restaurant> addMenuItem(
            @PathVariable Long restaurantId,
            @RequestBody MenuItem menuItem
    ) {
        return ResponseEntity.ok(restaurantService.addMenuItem(restaurantId, menuItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }
}