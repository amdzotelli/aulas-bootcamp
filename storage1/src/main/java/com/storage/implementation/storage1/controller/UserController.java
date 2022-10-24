package com.storage.implementation.storage1.controller;

import com.storage.implementation.storage1.model.UserBD;
import com.storage.implementation.storage1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserBD> novoUser(@RequestBody UserBD userBD) {
        UserBD newUser = service.inserir(userBD);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    @GetMapping("/{cod}")
    public ResponseEntity<UserBD> findUser(@PathVariable long cod) {
        Optional<UserBD> optional = service.find(cod);

        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<UserBD> update (@RequestBody UserBD userBD) {
        UserBD userUpdated = service.update(userBD);

        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{cod}")
    public ResponseEntity<Void> delete(@PathVariable long cod) {
        service.delete(cod);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
