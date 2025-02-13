package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.model.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> add(Book book) {
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public List<Book> loadAll() {
        return bookRepository.findAll();
    }
}
