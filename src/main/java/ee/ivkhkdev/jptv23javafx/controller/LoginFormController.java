package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
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
public class LoginFormController {
    private final UserServiceImpl userService;
    private SpringFXMLLoader springFXMLLoader;
    @FXML private Label lbInfo;
    @FXML private TextField tfLogin;
    @FXML private PasswordField pfPassword;

    public LoginFormController(SpringFXMLLoader springFXMLLoader, UserServiceImpl userService) {
        this.springFXMLLoader = springFXMLLoader;
        this.userService = userService;
    }

    @FXML private void login() throws IOException {
        if(userService.authenticate(tfLogin.getText(),pfPassword.getText())){
            loadMainForm();
        }else{
            lbInfo.setText("Нет такого пользователя, или неправильный пароль");
        }
    }

    private void loadMainForm() throws IOException {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/main/mainForm.fxml");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        getPrimaryStage().setScene(scene);
        getPrimaryStage().setTitle("JPTV23 библиотека - главная");
        getPrimaryStage().centerOnScreen();
        getPrimaryStage().show();
    }

    @FXML private void registration() throws IOException {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/registration/registration.fxml");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        getPrimaryStage().setScene(scene);
        getPrimaryStage().setTitle("JPTV23 библиотека - регистрация пользователя");
        getPrimaryStage().centerOnScreen();
        getPrimaryStage().show();
    }
    private Stage getPrimaryStage() {
        return Jptv23JavaFxApplication.primaryStage;
    }
    public void setMessage(String message){
        lbInfo.setText(message);
    }
}
