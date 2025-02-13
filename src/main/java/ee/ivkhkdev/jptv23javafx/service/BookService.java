package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.Set;
public interface BookService {
    Optional<Book> add(Book book);
    List<Book> loadAll();
}
