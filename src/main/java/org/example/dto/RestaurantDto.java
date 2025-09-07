package org.example.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RestaurantDto {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private List<MenuItemDto> menu;

    public RestaurantDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<MenuItemDto> getMenu() { return menu; }
    public void setMenu(List<MenuItemDto> menu) { this.menu = menu; }

    public void addMenuItem(MenuItemDto menuItem) {
        this.menu.add(menuItem);
    }
}
