package com.storage.tutoriais.repository;

import com.storage.tutoriais.model.Status;
import com.storage.tutoriais.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByTitleContaining(String title);
    List<Tutorial> findByStatus(Status status);

}
