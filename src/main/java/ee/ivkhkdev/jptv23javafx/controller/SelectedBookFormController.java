package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.service.BookService;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

@Component
public class SelectedBookFormController {
    private FormService formService;
    private BookService bookService;
    private Book book;

    public SelectedBookFormController(FormService formService, BookService bookService) {
        this.formService = formService;
        this.bookService = bookService;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    @FXML private void tackeOnBook(){

    }
    @FXML private void returnBook(){

    }
}
