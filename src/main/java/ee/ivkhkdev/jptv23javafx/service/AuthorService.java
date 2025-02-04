package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;

import java.util.Set;

public interface AuthorService {
    boolean add(String firstname, String lastname, Set<Book> books);
    Author getAuthorByFirstnameAndLastname(String firstname, String lastname);
}
