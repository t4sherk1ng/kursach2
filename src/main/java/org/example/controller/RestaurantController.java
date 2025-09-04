package org.example.controller;

import org.example.dto.MenuItemDto;
import org.example.dto.RestaurantDto;
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
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurant) {
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurant));
    }

    @PostMapping("/{restaurantId}/menu")
    public ResponseEntity<RestaurantDto> addMenuItem(
            @PathVariable Long restaurantId,
            @RequestBody MenuItemDto menuItem
    ) {
        return ResponseEntity.ok(restaurantService.addMenuItem(restaurantId, menuItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }
}
