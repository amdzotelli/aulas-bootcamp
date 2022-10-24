package com.example.storage2.service;

import com.example.storage2.model.Author;

public interface IAuthorService {

    Author insert(Author author);
    Author findById(Long id);

}
