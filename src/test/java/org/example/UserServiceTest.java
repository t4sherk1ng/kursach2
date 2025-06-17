package org.example;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUser_ReturnsSavedUser() {
        User user = new User();
        user.setEmail("test1@example.com");

        User saved = userService.createUser(user);

        assertNotNull(saved.getId());
        assertEquals("test1@example.com", saved.getEmail());
    }

    @Test
    void getUserById_ReturnsUser() {
        User user = new User();
        user.setEmail("findme@example.com");

        user = userRepository.save(user);

        User found = userService.getUserById(user.getId());

        assertEquals(user.getId(), found.getId());
        assertEquals("findme@example.com", found.getEmail());
    }

    @Test
    void getUserById_InvalidId_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.getUserById(999L);
        });

        assertTrue(exception.getMessage().contains("User not found"));
    }
}
