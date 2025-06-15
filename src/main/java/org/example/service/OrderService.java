package org.example.service;

import org.example.model.MenuItem;
import org.example.model.Restaurant;
import org.example.model.User;
import org.example.repository.MenuItemRepository;
import org.example.repository.RestaurantRepository;
import org.example.repository.UserRepository;
import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        RestaurantRepository restaurantRepository,
                        MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Transactional
    public Order createOrder(Long userId, Long restaurantId, Set<Long> itemIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        List<MenuItem> items = menuItemRepository.findAllById(itemIds);
        validateItems(items, restaurantId);

        double total = calculateTotal(items);

        Order order = new Order();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(new HashSet<>(items));
        order.setTotalPrice(total);
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }

    @Transactional
    public Order cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        if (order.getStatus() == OrderStatus.DELIVERED) {
            throw new IllegalStateException("Cannot cancel delivered order");
        }

        order.setStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }

    private void validateItems(List<MenuItem> items, Long restaurantId) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("No items selected");
        }

        for (MenuItem item : items) {
            if (!item.isAvailable()) {
                throw new IllegalStateException("Item " + item.getName() + " is unavailable");
            }
            if (!restaurantId.equals(item.getRestaurant().getId())) {
                throw new IllegalArgumentException("Item " + item.getName() + " belongs to another restaurant");
            }
        }
    }

    private double calculateTotal(List<MenuItem> items) {
        return items.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }
}