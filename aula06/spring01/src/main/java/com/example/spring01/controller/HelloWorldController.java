package com.example.spring01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// identificando qual controller no programa é esse -> de hello
@RestController
@RequestMapping("/hello")
// essa classe deve estar pronta para receber requisições
public class HelloWorldController {

    // quando a requisição que chegar no controller for get, vai acionar esse método
    @GetMapping
    public String getHello() {
        return "Olá mundo!";
    }

    @GetMapping("nome/{nome}")
    public String getHello(@PathVariable String nome) {
        return "Olá " + nome;
    }

}
