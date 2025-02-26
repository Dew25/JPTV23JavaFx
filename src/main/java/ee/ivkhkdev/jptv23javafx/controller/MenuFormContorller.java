package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MenuFormContorller implements Initializable {
    private FormService formService;
    @FXML private MenuItem miAddBook;
    @FXML private MenuItem miAddAuthor;
    @FXML private MenuItem miLogin;
    @FXML private MenuItem miLogout;
    @FXML private MenuItem miProfile;
    @FXML private Menu mAdmin;
    @FXML private Menu mBooks;


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

    private void initMenuVisible(){
        if(Jptv23JavaFxApplication.currentUser.getRoles().contains(
                Jptv23JavaFxApplication.ROLES.ADMINISTRATOR.toString())){
            miAddBook.setVisible(true);
            miAddAuthor.setVisible(true);
            miLogin.setVisible(false);
            miLogout.setVisible(true);
            miProfile.setVisible(true);
            mAdmin.setVisible(true);
            mBooks.setVisible(true);
        }else if(Jptv23JavaFxApplication.currentUser.getRoles().contains(Jptv23JavaFxApplication.ROLES.MANAGER.toString())){
            miAddBook.setVisible(true);
            miAddAuthor.setVisible(true);
            miLogin.setVisible(false);
            miLogout.setVisible(true);
            miProfile.setVisible(true);
            mAdmin.setVisible(false);
            mBooks.setVisible(true);
        }else if(Jptv23JavaFxApplication.currentUser.getRoles().contains(Jptv23JavaFxApplication.ROLES.USER.toString())){
            miAddBook.setVisible(false);
            miAddAuthor.setVisible(false);
            miLogin.setVisible(false);
            miLogout.setVisible(true);
            miProfile.setVisible(true);
            mAdmin.setVisible(false);
            mBooks.setVisible(false);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initMenuVisible();
    }
}
