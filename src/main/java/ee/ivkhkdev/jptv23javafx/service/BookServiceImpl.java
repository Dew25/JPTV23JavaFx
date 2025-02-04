package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.model.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean add(String firstname, Set<Author> authors, int publicationYear, int quantity, int count) {
        Book book = new Book();
        book.setAuthors(authors);
        book.setPublicationYear(publicationYear);
        book.setQuantity(quantity);
        book.setCount(count);
        bookRepository.save(book);
        return true;
    }
}
