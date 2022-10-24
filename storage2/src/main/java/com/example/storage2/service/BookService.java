package com.example.storage2.service;

import com.example.storage2.model.Book;
import com.example.storage2.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepository repository;

    @Override
    public Book findById(long id) {
        Optional<Book> optionalBook = repository.findById(id);
        return optionalBook.orElse(null);
    }
}
