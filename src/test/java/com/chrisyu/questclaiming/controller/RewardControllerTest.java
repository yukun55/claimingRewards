package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.ClaimedRewardId;
import com.chrisyu.questclaiming.model.Reward;
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
public class RewardControllerTest {
    @Autowired
    private RewardController rewardController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test Should Pass When Reward Controller Context Successfully Load")
    public void contextLoads() throws Exception {
        // we test that our controller is not null
        assertThat(rewardController).isNotNull();
    }

    @Test
    @DisplayName("Test Should Save Reward When Call POST /rewards")
    public void shouldPassWhenAddANewRewardResponseIsOK() throws Exception{
        //we test that call POST /rewards can successfully receive response
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/rewards")
                .content(asJsonString(new Reward(UUID.randomUUID().toString(), 0.0, false)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    @DisplayName("Test Should Save Claimed Reward When Call POST /claimReward/{rewardId}")
    public void shouldPassWhenAddANewClaimedRewardResponseIsOk() throws Exception{
        //we test that call POST /claimReward/{rewardId} can successfully receive response
        rewardController.addReward(new Reward("1", 0.0, false));
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/claimReward/{rewardId}", "1")
                .content(asJsonString(new ClaimedRewardId(null, "1")))
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
