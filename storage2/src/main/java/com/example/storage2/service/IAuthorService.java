package com.example.storage2.service;

import com.example.storage2.dto.AuthorDTO;
import com.example.storage2.model.Author;

public interface IAuthorService {

    Author insert(Author author);
    Author findById(long id);
    void delete(long id);
    AuthorDTO getById(long id);
    Author getNAtiveById(long id);
    AuthorDTO getDtoEagle(long id);

}
