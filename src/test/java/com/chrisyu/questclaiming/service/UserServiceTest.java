package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.UserAlreadyExistException;
import com.chrisyu.questclaiming.model.User;
import com.chrisyu.questclaiming.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Test Should Pass When UserService Context Successfully Load")
    public void shouldLoadContext() throws Exception {
        // we test that our UserService is not null
        assertThat(userService).isNotNull();
    }

    @Test
    @DisplayName("Test Should Pass When Add New User")
    public void shouldPassWhenAddNewUser() {
        User user = new User(null, "");
        User userToTest = userService.addUser(user);
        assertEquals(user.getId(), userToTest.getId());
    }
}
