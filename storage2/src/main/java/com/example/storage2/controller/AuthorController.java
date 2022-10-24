package com.example.storage2.controller;

import com.example.storage2.model.Author;
import com.example.storage2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    ResponseEntity<Author> insert(@RequestBody Author author) {
        Author newAuthor = service.insert(author);
        return ResponseEntity.ok(newAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable long id) {
        Author author = service.findById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }

}
