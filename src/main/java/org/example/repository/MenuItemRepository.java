package org.example.repository;


import org.example.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    @Query("SELECT m FROM MenuItem m WHERE m.restaurant.id = :restaurantId AND m.id IN :itemIds")
    List<MenuItem> findMenuItemsByRestaurantAndIds(
            @Param("restaurantId") Long restaurantId,
            @Param("itemIds") List<Long> itemIds
    );
}