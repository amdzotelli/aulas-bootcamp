package com.example.storage2.service;

import com.example.storage2.dto.AuthorDTO;
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
        author.getAddress().setAuthor(author);
        return repository.save(author);
    }

    @Override
    public Author findById(long id) {
        Optional<Author> optionalAuthor = repository.findById(id);
        return optionalAuthor.orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public AuthorDTO getById(long id) {
        return repository.getById(id);
    }

    @Override
    public Author getNAtiveById(long id) {
        return repository.getNativeById(id);
    }

    @Override
    public AuthorDTO getDtoEagle(long id) {
        return repository.getDtoEagle(id);
    }


}
