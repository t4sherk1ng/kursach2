//package org.example;
//
//import org.example.model.*;
//import org.example.repository.*;
//import org.example.service.OrderService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class OrderServiceTest {
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RestaurantRepository restaurantRepository;
//
//    @Autowired
//    private MenuItemRepository menuItemRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Test
//    void createOrder_ReturnsSavedOrder() {
//        User user = new User();
//        user.setEmail("test@example.com");
//        userRepository.save(user);
//        Restaurant restaurant = new Restaurant();
//        restaurant.setName("Testaurant");
//        restaurantRepository.save(restaurant);
//        MenuItem item = new MenuItem();
//        item.setName("Burger");
//        item.setPrice(9.99);
//        item.setAvailable(true);
//        item.setRestaurant(restaurant);
//        menuItemRepository.save(item);
//        Order order = orderService.createOrder(user.getId(), restaurant.getId(), Set.of(item.getId()));
//        assertNotNull(order.getId());
//        assertEquals(user.getId(), order.getUser().getId());
//        assertEquals(restaurant.getId(), order.getRestaurant().getId());
//        assertEquals(1, order.getItems().size());
//    }
//}
