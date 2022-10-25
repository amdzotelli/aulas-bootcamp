package com.storage.tutoriais.repository;

import com.storage.tutoriais.model.Status;
import com.storage.tutoriais.model.Tutorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TutorialRepositoryTest {

    @Autowired
    private TutorialRepository repository;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
    }

    @Test
    void save_returnTutorial_whenTutorialSentIsValid() {
        Tutorial newTutorial = new Tutorial(
                null,
                "Título1",
                "Descrição 1",
                Status.DRAFT
        );

        Tutorial tutorialSaved = repository.save(newTutorial);

        assertThat(tutorialSaved).isNotNull();
        assertThat(tutorialSaved.getId()).isPositive();
        assertThat(tutorialSaved.getStatus()).isEqualTo(Status.DRAFT);
        assertThat(tutorialSaved.getTitle()).isEqualTo(newTutorial.getTitle());
    }

    @Test
    void findById_returnTutorial_whenIdTutorialExists() {
        Tutorial newTutorial = new Tutorial(
                null,
                "Título1",
                "Descrição 1",
                Status.DRAFT
        );

        Tutorial tutorialSaved = repository.save(newTutorial);

        Optional<Tutorial> tutorialOptional = repository.findById(tutorialSaved.getId());

        assertThat(tutorialOptional).isPresent();
        assertThat(tutorialOptional.get().getId()).isPositive();
        assertThat(tutorialOptional.get().getStatus()).isEqualTo(Status.DRAFT);
    }

    @Test
    void findById_returnOptionalEmpty_whenIdTutorialDoesntExist() {
        Optional<Tutorial> tutorialOptional = repository.findById(1L);

        assertThat(tutorialOptional).isEmpty();
    }

    @Test
    void findByStatus_returnTutorialList_whenStatusExists() {
        Tutorial newTutorial = new Tutorial(
                null,
                "Título1",
                "Descrição 1",
                Status.DRAFT
        );

        Tutorial tutorialSaved = repository.save(newTutorial);

        List<Tutorial> tutorials = repository.findByStatus(Status.DRAFT);

        assertThat(tutorials).hasSize(1);
        assertThat(tutorials.get(0).getId()).isEqualTo(tutorialSaved.getId());
    }

    @Test
    void findByStatus_returnEmptyList_whenStatusDoesntExist() {
        List<Tutorial> tutorials = repository.findByStatus(Status.DRAFT);

        assertThat(tutorials).isEmpty();
    }



}
