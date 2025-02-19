package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import ee.ivkhkdev.jptv23javafx.service.UserService;
import ee.ivkhkdev.jptv23javafx.service.UserServiceImpl;
import ee.ivkhkdev.jptv23javafx.tools.SpringFXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class RegistrationController {
    public UserService userService;
    private final FormService formService;

    public RegistrationController(UserService userService, FormService formService) {
        this.userService = userService;
        this.formService = formService;
    }

    @FXML private Label lbInfo;
    @FXML private TextField tfFirstname;
    @FXML private TextField tfLastname;
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPassword;

    @FXML private void registrationUser() throws IOException {
        AppUser appUser = new AppUser();
        appUser.setFirstname(tfFirstname.getText());
        appUser.setLastname(tfLastname.getText());
        appUser.setUsername(tfUsername.getText());
        appUser.setPassword(pfPassword.getText());
        appUser.getRoles().add(Jptv23JavaFxApplication.ROLES.USER.toString());
        if(userService.add(appUser)){
            formService.loadLoginForm();
        }else{
            lbInfo.setText("Пользователя добавить не удалось");
        }
    }
    @FXML private void goToLoginForm(){
        formService.loadLoginForm();
    }

}
