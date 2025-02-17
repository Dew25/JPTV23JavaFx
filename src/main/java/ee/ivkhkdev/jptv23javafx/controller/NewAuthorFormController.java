package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.service.FormService;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

@Component
public class NewAuthorFormController {
    private FormService formService;

    public NewAuthorFormController(FormService formService) {
        this.formService = formService;
    }

    @FXML private void goToMainForm(){
        formService.loadMainForm();
    }
    @FXML private void addAuthor(){}
}
