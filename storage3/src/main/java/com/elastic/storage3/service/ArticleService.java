package com.elastic.storage3.service;

import com.elastic.storage3.model.Article;
import com.elastic.storage3.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository repository;

    @Override
    public Article save(Article article) {
        return repository.save(article);
    }
}
