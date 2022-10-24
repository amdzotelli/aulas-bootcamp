package com.storage.implementation.storage1.service;

import com.storage.implementation.storage1.model.UserBD;
import com.storage.implementation.storage1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserBD inserir(UserBD userBD) {
        return repository.save(userBD);
    }

    public Optional<UserBD> find (long cod) {
        return repository.findById(cod);
    }


    public UserBD update(UserBD userBD) {
        return repository.save(userBD);
    }

    public void delete(long cod) {
        repository.deleteById(cod);
    }

}
