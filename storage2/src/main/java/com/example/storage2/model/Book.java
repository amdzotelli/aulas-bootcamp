package com.example.storage2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    @JsonIgnoreProperties("books")
    private Genre genre;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private Set<Author> authors;

}
