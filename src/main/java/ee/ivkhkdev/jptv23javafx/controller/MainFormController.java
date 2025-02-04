package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.service.AuthorService;
import ee.ivkhkdev.jptv23javafx.service.BookService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

@Component
public class MainFormController implements Initializable {
    private BookService bookService;
    private AuthorService authorService;

    public MainFormController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @FXML private TableView<Book> tvListBooks;

    private void saveBooks(){
        authorService.add("Lev","Tolstory");
        Set<Author> authors = new HashSet<>();
        authors.add(authorService.getAuthorByFirstnameAndLastname("Lev","Tolstoy"));
        bookService.add("Voina i mir",authors, 2000,3,3);authorService.add("Lev","Tolstory");

        authorService.add("Иван","Тургенев");
        Set<Author> authors1 = new HashSet<>();
        authors1.add(authorService.getAuthorByFirstnameAndLastname("Иван","Тургенев"));
        bookService.add("Отцы и дети",authors1, 2001,2,2);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saveBooks();
    }
}
