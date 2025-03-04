package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.service.BookService;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import javafx.fxml.FXML;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class SelectedBookFormController {
    private FormService formService;
    private BookService bookService;
    private Book book;
    @FXML private ImageView ivCover;

    public SelectedBookFormController(FormService formService, BookService bookService) {
        this.formService = formService;
        this.bookService = bookService;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    @FXML private void tackeOnBook(){
        Stage stage = (Stage) ivCover.getScene().getWindow();
        stage.close();
    }
    @FXML private void returnBook(){

    }
}
