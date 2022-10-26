package com.elastic.storage3.service;

import com.elastic.storage3.model.Article;
import com.elastic.storage3.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository repository;

    @Override
    public Article save(Article article) {
        return repository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Article> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Article update(Article article) {
        return repository.save(article);
    }

}
