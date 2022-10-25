package com.storage.tutoriais.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storage.tutoriais.controller.TutorialController;
import com.storage.tutoriais.model.Status;
import com.storage.tutoriais.model.Tutorial;
import com.storage.tutoriais.repository.TutorialRepository;
import com.storage.tutoriais.service.TutorialService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TutorialIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TutorialRepository repository;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
    }

    @Test
    void insert_returnNewTutorial_whenTutorialIsValid() throws Exception {
        Tutorial tutorial = new Tutorial(null, "Título", "Descrição", null);

        ResultActions result = mockMvc.perform(
                post("/tutorial")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(tutorial))
        );

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", CoreMatchers.is("Título")));

    }

//    response.andExpect(status().isOk())
//            .andExpect(jsonPath("$", CoreMatchers.is(propertyValue.doubleValue())));

    @Test
    void updateStatusPublished() {
    }

    @Test
    void getByTitle() {
    }

    @Test
    void getPublished() {
    }
}