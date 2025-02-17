package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;

import java.util.List;
import java.util.Optional;


public interface AuthorService {
    Optional<Author> add(Author author);
    public List<Author> loadAll();
}
