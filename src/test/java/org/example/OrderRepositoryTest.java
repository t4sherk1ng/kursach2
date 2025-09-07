package org.example;

import org.example.model.*;
import org.example.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void saveOrder_ValidData_PersistsCorrectly() {
        User user = new User();
        user.setEmail("user@example.com");
        entityManager.persist(user);
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Pizza Hut");
        entityManager.persist(restaurant);
        MenuItem item = new MenuItem();
        item.setName("Pizza");
        item.setPrice(10.99);
        item.setAvailable(true);
        item.setRestaurant(restaurant);
        entityManager.persist(item);
        Order order = new Order();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());
        order.setItems(Collections.singleton(item));
        order.setTotalPrice(10.99);
        Order saved = orderRepository.save(order);
        assertNotNull(saved.getId());
        assertEquals(OrderStatus.CREATED, saved.getStatus());
        assertEquals(1, saved.getItems().size());
        assertEquals("Pizza", saved.getItems().iterator().next().getName());
    }
}