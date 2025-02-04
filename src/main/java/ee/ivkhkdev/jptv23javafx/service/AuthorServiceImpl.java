package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.model.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean add(String firstname, String lastname, Set<Book> books) {
        Author author = new Author(firstname, lastname);
        author.setBooks(books);
        authorRepository.save(author);
        return true;
    }
}
