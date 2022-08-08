package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private UserController userController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test Should Pass When User Controller Context Successfully Load")
    public void contextLoads() throws Exception {
        // we test that our controller is not null
        assertThat(userController).isNotNull();
    }

    @Test
    @DisplayName("Test Should Save User When Call POST /users")
    public void shouldPassWhenAddANewUserResponseIsOK() throws Exception{
        //we test that call POST /users can successfully receive response
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .content(asJsonString(new User(UUID.randomUUID().toString(), "Test")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
