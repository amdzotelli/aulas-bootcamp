package com.elastic.storage3.repository;

import com.elastic.storage3.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
    List<Article> findAll();
}
