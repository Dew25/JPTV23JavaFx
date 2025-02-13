package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.service.AuthorService;
import ee.ivkhkdev.jptv23javafx.service.BookService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

@Component
public class MainFormController implements Initializable {
    private BookService bookService;
    private AuthorService authorService;
    @FXML private TableView<Book> tvListBooks;
    @FXML private TableColumn<Book,String> tcId;
    @FXML private TableColumn<Book,String> tcTitle;
    @FXML private TableColumn<Book,String> tcAuthors;
    @FXML private TableColumn<Book,String> tcPublicationYear;
    @FXML private TableColumn<Book,String> tcQuantity;
    @FXML private TableColumn<Book,String> tcCount;
    public MainFormController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    private void saveBooks(){
        Author author = new Author();
        author.setFirstname("Lev");
        author.setLastname("Tolstoy");
        Optional<Author> optionalAuthor = authorService.add(author);
        Book book = new Book();
        book.setTitle("Voina i mir");
        book.setCount(2);
        book.setPublicationYear(2000);
        book.setQuantity(2);
        book.getAuthors().add(optionalAuthor.get());
        Optional<Book> optionalBook = bookService.add(book);
        author.getBooks().add(optionalBook.get());
        authorService.add(author);
        Author author2 = new Author();
        author2.setFirstname("Иван");
        author2.setLastname("Тургенев");
        Optional<Author> optionalAuthor2 = authorService.add(author2);
        Book book2 = new Book();
        book2.setTitle("Отцы и дети");
        book2.setCount(3);
        book2.setPublicationYear(2001);
        book2.setQuantity(3);
        book2.getAuthors().add(optionalAuthor2.get());
        Optional<Book> optionalBook2 = bookService.add(book2);
        author2.getBooks().add(optionalBook2.get());
        authorService.add(author2);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saveBooks();
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.addAll(bookService.loadAll());
        tvListBooks.setItems(books);
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tcAuthors.setCellValueFactory(cellData -> {
            Set<Author> authors = cellData.getValue().getAuthors();
            if (authors == null || authors.isEmpty()) {
                return new SimpleStringProperty("No authors");
            }
            String authorsString = authors.stream()
                    .map(author -> author.getFirstname() + " " + author.getLastname())
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("Unknown");
            return new SimpleStringProperty(authorsString);
        });
        tcPublicationYear.setCellValueFactory(new PropertyValueFactory<>("publicationYear"));
        tcQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tcCount.setCellValueFactory(new PropertyValueFactory<>("count"));
    }
}
