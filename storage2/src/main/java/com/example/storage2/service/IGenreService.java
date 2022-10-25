package com.example.storage2.service;

import com.example.storage2.model.Genre;
import com.example.storage2.repository.GenreRepository;

import java.util.List;

public interface IGenreService {

    Genre findById(long id);

    List<Genre> findAll();
}
