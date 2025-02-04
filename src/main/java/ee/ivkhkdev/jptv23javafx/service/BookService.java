package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import java.util.Set;
public interface BookService {
    boolean add(String firstname, Set<Author> authors, int publicationYear, int quantity, int count);
}
