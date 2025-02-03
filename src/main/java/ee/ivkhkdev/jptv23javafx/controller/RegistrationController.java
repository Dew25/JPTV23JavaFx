package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
import ee.ivkhkdev.jptv23javafx.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RegistrationController {
    public UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @FXML private Label lbInfo;
    @FXML private TextField tfFirstname;
    @FXML private TextField tfLastname;
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPassword;

    @FXML private void registrationUser(){
        AppUser user = userService.add(tfFirstname.getText(), tfLastname.getText(), tfUsername.getText(), pfPassword.getText());
        lbInfo.setText("Добавлен пользователь "+ user.getUsername()+" с ролью: "+ Arrays.toString(user.getRoles().toArray()));
    }
}
