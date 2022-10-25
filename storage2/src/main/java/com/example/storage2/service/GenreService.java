package com.example.storage2.service;

import com.example.storage2.model.Genre;
import com.example.storage2.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService implements IGenreService {
    private final GenreRepository repository;

    @Override
    public Genre findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> findAll() {
        return repository.findAll();
    }
}
