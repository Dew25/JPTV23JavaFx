package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

@Component
public class MenuFormContorller {
    private FormService formService;

    public MenuFormContorller(FormService formService) {
        this.formService = formService;
    }

    @FXML private void showNewBookForm(){
        formService.loadNewBookForm();

    }
    @FXML private void showNewAuthorForm(){
        formService.loadNewAuthorForm();
    }
    @FXML private void showListBooks(){
        formService.loadMainForm();
    }
    @FXML private void showLoginForm(){
        formService.loadLoginForm();
    }
    @FXML private void logout(){
        Jptv23JavaFxApplication.currentUser = null;
        formService.loadLoginForm();
    }
    @FXML private void showProfileForm(){}
    @FXML private void showAdminPanel(){}
}
