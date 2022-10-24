package com.storage.implementation.storage1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity // indica q classe será persistida no DB
@Table(name = "tb_user") // nome dado a tabela no DB
public class UserBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automático no BD 1,2, 3...
    private long cod;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(name = "e_mail", length = 100, unique = true)
    private String email;
}
