package org.example.service;

import org.example.dto.MenuItemDto;
import org.example.dto.RestaurantDto;
import org.example.model.MenuItem;
import org.example.model.Restaurant;
import org.example.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public RestaurantDto createRestaurant(RestaurantDto restaurant) {
        return modelMapper.map(restaurantRepository.save(modelMapper.map(restaurant, Restaurant.class)), RestaurantDto.class);
    }

    public Optional<RestaurantDto> getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class));
    }

    @Transactional
    public RestaurantDto addMenuItem(Long restaurantId, MenuItemDto menuItem) {
        RestaurantDto restaurant = getRestaurantById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        restaurant.addMenuItem(menuItem);

        Restaurant saved = restaurantRepository.save(modelMapper.map(restaurant, Restaurant.class));
        return modelMapper.map(saved, RestaurantDto.class);
    }

}