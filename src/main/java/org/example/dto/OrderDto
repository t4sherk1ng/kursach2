package org.example.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class OrderDto {

    private Long id;                // Может быть null при создании
    private Long userId;
    private Long restaurantId;
    private Set<Long> itemIds;      // ID выбранных блюд
    private double totalPrice;      // Автоматически считается на бэке
    private LocalDateTime createdAt;
    private String status;          // ENUM как строка

    public OrderDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }

    public Set<Long> getItemIds() { return itemIds; }
    public void setItemIds(Set<Long> itemIds) { this.itemIds = itemIds; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
