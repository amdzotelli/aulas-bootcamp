package com.elastic.storage3.controller;

import com.elastic.storage3.model.Article;
import com.elastic.storage3.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService service;

    @PostMapping
    public ResponseEntity<Article> insert(@RequestBody Article article) {
        Article newArticle = service.save(article);
        return new ResponseEntity<>(newArticle, HttpStatus.CREATED);

    }

}
