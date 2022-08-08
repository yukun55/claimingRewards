package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.CompletedQuestId;
import com.chrisyu.questclaiming.model.Quest;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestControllerTest {
    @Autowired
    private QuestController questController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test Should Pass When Quest Controller Context Successfully Load")
    public void shouldLoadContext() throws Exception {
        // we test that our controller is not null
        assertThat(questController).isNotNull();
    }

    @Test
    @DisplayName("Test Should Save Quest When Call POST /quests")
    public void shouldPassWhenAddANewQuestResponseIsOK() throws Exception{
        //we test that call POST /quests can successfully receive response
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/quests")
                .content(asJsonString(new Quest(UUID.randomUUID().toString(), "", "", false)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    @DisplayName("Test Should List Quest When Call GET /quests/{questId}")
    public void shouldPassWhenSearchAQuestResponseIsOk() throws Exception {
        //we test that call GET /quests/{questId} can successfully receive response
        String id = UUID.randomUUID().toString();
        questController.addQuest(new Quest(id, "", "", false));
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/quests/{questId}", id)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }


    @Test
    @DisplayName("Test Should Save Completed Quest When Call POST /completeQuest/{questId}")
    public void shouldPassWhenAddANewCompleteQuestResponseIsOk() throws Exception{
        //we test that call POST /completeQuest/{questId} can successfully receive response
        String id = UUID.randomUUID().toString();
        questController.addQuest(new Quest(id, "", "", false));
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/completeQuest/{questId}", id)
                .content(asJsonString(new CompletedQuestId(null, id)))
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
