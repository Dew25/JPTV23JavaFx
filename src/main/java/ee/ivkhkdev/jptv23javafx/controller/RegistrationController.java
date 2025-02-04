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
public class RegistrationController {
    public UserServiceImpl userService;
    private final SpringFXMLLoader springFXMLLoader;

    public RegistrationController(UserServiceImpl userService, SpringFXMLLoader springFXMLLoader) {
        this.userService = userService;
        this.springFXMLLoader = springFXMLLoader;
    }

    @FXML private Label lbInfo;
    @FXML private TextField tfFirstname;
    @FXML private TextField tfLastname;
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPassword;

    @FXML private void registrationUser() throws IOException {
        if(userService.add(tfFirstname.getText(), tfLastname.getText(), tfUsername.getText(), pfPassword.getText())){
            loadLoginForm();
        }else{
            lbInfo.setText("Пользователя добавить не удалось");
        }
    }

    private Stage getPrimaryStage(){
        return Jptv23JavaFxApplication.primaryStage;
    }

    public void loadLoginForm() throws IOException {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/loginForm/loginForm.fxml");
        Parent root = fxmlLoader.load();
        LoginFormController controller = fxmlLoader.getController();
        controller.setMessage("Пользователь успешно зарегистрирован");
        Scene scene = new Scene(root);
        getPrimaryStage().setScene(scene);
        getPrimaryStage().setTitle("JPTV23 библиотека - Вход");
        getPrimaryStage().centerOnScreen();
        getPrimaryStage().show();
    }
}
