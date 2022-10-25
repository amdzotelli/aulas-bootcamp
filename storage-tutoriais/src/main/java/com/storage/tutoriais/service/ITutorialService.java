package com.storage.tutoriais.service;

import com.storage.tutoriais.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface ITutorialService {

    Tutorial insert(Tutorial tutorial);

    List<Tutorial> getAll();

    List<Tutorial> getPublished();

    List<Tutorial> getByTitle(String title);

    Optional<Tutorial> getById(Long id);

    Tutorial update(Tutorial tutorial);

    void deleteById(Long id);

    void deleteAll();

}
