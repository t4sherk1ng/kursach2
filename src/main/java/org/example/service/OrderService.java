package org.example.service;

import org.example.dto.OrderDto;
import org.example.dto.UserDto;
import org.example.model.MenuItem;
import org.example.model.Restaurant;
import org.example.model.User;
import org.example.repository.MenuItemRepository;
import org.example.repository.RestaurantRepository;
import org.example.repository.UserRepository;
import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    private ModelMapper modelMapper;

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
    public OrderDto createOrder(Long userId, Long restaurantId, Set<Long> itemIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        List<MenuItem> items = menuItemRepository.findMenuItemsByRestaurantAndIds(
                restaurantId,
                new ArrayList<>(itemIds)
        );

        validateItems(items, restaurantId);

        Order order = new Order();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);

        for (MenuItem item : items) {
            order.addItem(item);
        }

        return modelMapper.map(orderRepository.save(order), OrderDto.class);
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

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }
}