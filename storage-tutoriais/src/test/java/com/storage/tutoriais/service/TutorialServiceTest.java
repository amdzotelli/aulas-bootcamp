package com.storage.tutoriais.service;

import com.storage.tutoriais.model.Status;
import com.storage.tutoriais.model.Tutorial;
import com.storage.tutoriais.repository.TutorialRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class TutorialServiceTest {

    @InjectMocks
    private TutorialService service;

    @Mock
    private TutorialRepository repository;

    @Test
    void insert_returnNewTutorial_whenTutorialValid() {

        BDDMockito.when(repository.save(ArgumentMatchers.any(Tutorial.class)))
                .thenReturn(
                        new Tutorial(
                                1L,
                                "Título 1",
                                "Descrição 1",
                                Status.DRAFT
                        ));

        Tutorial newTutorial = service.insert(
                new Tutorial(null, "Título 1", "Descrição 1", null)
        );

        assertThat(newTutorial).isNotNull();
        assertThat(newTutorial.getId()).isEqualTo(1L);
        assertThat(newTutorial.getStatus()).isEqualTo(Status.DRAFT);

    }

    @Test
    void getAll() {
    }

    @Test
    void getPublished() {
    }

    @Test
    void getByTitle() {
    }

    @Test
    void getById() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }
}