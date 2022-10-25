package com.storage.tutoriais.service;

import com.storage.tutoriais.exception.InvalidParamException;
import com.storage.tutoriais.model.Status;
import com.storage.tutoriais.model.Tutorial;
import com.storage.tutoriais.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorialService implements ITutorialService {

    private final TutorialRepository repository;

    @Override
    public Tutorial insert(Tutorial tutorial) {

        if (tutorial == null) {
            throw new InvalidParamException("O tutorial não pode ser nulo.");
        }

        if (tutorial.getId() != null) {
            throw new InvalidParamException("O tutorial não pode ter Id");
        }

        tutorial.setStatus(Status.DRAFT);
        return repository.save(tutorial);

    }

    @Override
    public List<Tutorial> getAll() {
        return null;
    }

    @Override
    public List<Tutorial> getPublished() {
        return null;
    }

    @Override
    public List<Tutorial> getByTitle(String title) {
        return repository.findByTitleContaining(title);
    }

    @Override
    public Optional<Tutorial> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Tutorial update(Tutorial tutorial) {
        if (tutorial == null) {
            throw new InvalidParamException("O tutorial não pode ser nulo.");
        }

        if (tutorial.getId() == null) {
            throw new InvalidParamException("O tutorial deve ter Id");
        }
        return repository.save(tutorial);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
