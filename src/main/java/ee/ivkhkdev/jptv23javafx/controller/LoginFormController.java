package ee.ivkhkdev.jptv23javafx.controller;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
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
    private SpringFXMLLoader springFXMLLoader;
    @FXML private Label lbInfo;
    @FXML private TextField tfLogin;
    @FXML private PasswordField pfPassword;

    public LoginFormController(SpringFXMLLoader springFXMLLoader) {
        this.springFXMLLoader = springFXMLLoader;
    }

    @FXML private void login(){
        lbInfo.setText("Нажата кнопка Войти");
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
}
