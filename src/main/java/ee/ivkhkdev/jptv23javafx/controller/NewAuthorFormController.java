package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import ee.ivkhkdev.jptv23javafx.service.AuthorService;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;
import javafx.scene.control.TextField;


@Component
public class NewAuthorFormController {
    private FormService formService;
    private AuthorService authorService;
    @FXML private Label lbInfo;
    @FXML private TextField tfFirstname;
    @FXML private TextField tfLastname;

    public NewAuthorFormController(FormService formService, AuthorService authorService) {
        this.formService = formService;
        this.authorService = authorService;
    }

    @FXML private void goToMainForm(){
        formService.loadMainForm();
    }
    @FXML private void addAuthor(){
        try {
            Author author = new Author();
            if(tfFirstname.getText().equals("") || tfLastname.getText().equals("")){
                lbInfo.setText("Вы не заполнили поле");
            }else{
                author.setFirstname(tfFirstname.getText());
                author.setLastname(tfLastname.getText());
                authorService.add(author);
                formService.loadMainForm();
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
