package com.example.storage2.controller;

import com.example.storage2.model.Book;
import com.example.storage2.model.Genre;
import com.example.storage2.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping("{id}")
    public ResponseEntity<Genre> findById(@PathVariable long id) {
        Genre genre = service.findById(id);

        if (genre != null) {
            return ResponseEntity.ok(genre);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
