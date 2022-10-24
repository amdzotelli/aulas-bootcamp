package com.example.storage2.service;

import com.example.storage2.model.Author;
import com.example.storage2.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepository repository;

      @Override
    public Author insert(Author author) {
        return repository.save(author);
    }

    @Override
    public Author findById(Long id) {
        Optional<Author> optionalAuthor = repository.findById(id);
        return optionalAuthor.orElse(null);
    }

}
