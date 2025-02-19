package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.service.FormService;
import ee.ivkhkdev.jptv23javafx.service.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginFormController {
    private final UserServiceImpl userService;
    private FormService formService;

    @FXML private Label lbInfo;
    @FXML private TextField tfLogin;
    @FXML private PasswordField pfPassword;

    public LoginFormController(FormService formService, UserServiceImpl userService) {
        this.formService = formService;
        this.userService = userService;
    }

    @FXML private void login() throws IOException {
        if(userService.authenticate(tfLogin.getText(),pfPassword.getText())){
            formService.loadMainForm();
        }else{
            lbInfo.setText("Нет такого пользователя, или неправильный пароль");
        }
    }



    @FXML private void registration(){
        formService.loadRegistrationForm();
    }

    public void setMessage(String message){
        lbInfo.setText(message);
    }
}
