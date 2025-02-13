package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.model.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> add(Author author) {
            return Optional.of(authorRepository.save(author));
    }


}
