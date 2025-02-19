package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.service.AuthorService;
import ee.ivkhkdev.jptv23javafx.service.BookService;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class NewBookFormController implements Initializable {
    private FormService formService;
    private AuthorService authorService;
    private BookService bookService;

    @FXML private Label lbInfo;
    @FXML private TextField tfTitle;
    @FXML private ListView<Author> lvAuthors;
    @FXML private TextField tfPublicationYear;
    @FXML private TextField tfQuantity;

    public NewBookFormController(FormService formService, AuthorService authorService, BookService bookService) {
        this.formService = formService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @FXML
    public void showMainFrom(){
        formService.loadMainForm();
    }
    @FXML
    private void addBook() {
        try {
            Book book = new Book();
            if(tfTitle.getText().equals("") || lvAuthors.getSelectionModel().isEmpty()
                    || tfPublicationYear.getText().equals("") || tfQuantity.getText().equals("")){
                lbInfo.setText("Заполните все поля формы!");
            }else{
                book.setTitle(tfTitle.getText());
                book.setPublicationYear(Integer.parseInt(tfPublicationYear.getText()));
                book.setQuantity(Integer.parseInt(tfQuantity.getText()));
                book.setCount(book.getQuantity());
                book.getAuthors().addAll(lvAuthors.getSelectionModel().getSelectedItems());
                bookService.add(book);
                formService.loadMainForm();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
    @FXML private void goToMainForm(){
        formService.loadMainForm();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Author> authors = FXCollections.observableArrayList();
        authors.addAll(authorService.loadAll());
        lvAuthors.setItems(authors);
        lvAuthors.setCellFactory(new Callback<ListView<Author>, ListCell<Author>>() {
            @Override
            public ListCell<Author> call(ListView<Author> param) {
                return new ListCell<Author>() {
                    @Override
                    protected void updateItem(Author author, boolean empty) {
                        super.updateItem(author, empty);
                        if (author == null || empty) {
                            setText(null);
                        } else {
                            setText(author.getFirstname() + " " + author.getLastname()); //
                        }
                    }
                };
            }
        });
    }
}
