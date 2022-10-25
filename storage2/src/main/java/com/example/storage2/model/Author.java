package com.example.storage2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "author")
    @JsonIgnoreProperties("author")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "author_books",
            joinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("authors")
    private Set<Book> books;

}
