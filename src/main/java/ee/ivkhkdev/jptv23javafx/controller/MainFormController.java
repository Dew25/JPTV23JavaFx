package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.service.AuthorService;
import ee.ivkhkdev.jptv23javafx.service.BookService;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

@Component
public class MainFormController implements Initializable {
    private FormService formService;
    private BookService bookService;
    private AuthorService authorService;

    @FXML private VBox vbMainRoot;
    @FXML private TableView<Book> tvListBooks;
    @FXML private TableColumn<Book,String> tcId;
    @FXML private TableColumn<Book,String> tcTitle;
    @FXML private TableColumn<Book,String> tcAuthors;
    @FXML private TableColumn<Book,String> tcPublicationYear;
    @FXML private TableColumn<Book,String> tcQuantity;
    @FXML private TableColumn<Book,String> tcCount;

    public MainFormController(FormService formService, BookService bookService, AuthorService authorService) {
        this.formService = formService;
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
    @FXML private void handleDoubleClick(javafx.scene.input.MouseEvent event){
        if (event.getClickCount() == 2) { // Проверяем, что это двойной клик
            Book selectedBook = tvListBooks.getSelectionModel().getSelectedItem();
            if (selectedBook != null) {
                showBookDetails(selectedBook);
            }
        }
    }
    private void showBookDetails(Book book) {
        try {
            // Загрузка FXML файла для модального окна
            formService.loadSelectedBookFormModal(book);
            // Обновляем данные в таблице после закрытия модального окна
            tvListBooks.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent vbMenuRoot = formService.loadMenuForm();
        vbMainRoot.getChildren().addFirst(vbMenuRoot);
        if(authorService.loadAll().isEmpty()){
            saveBooks();
        }
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
