package com.elastic.storage3.repository;

import com.elastic.storage3.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
}
