package com.example.storage2.repository;

import com.example.storage2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
