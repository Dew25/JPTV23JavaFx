package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.tools.SpringFXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FormService {
    private SpringFXMLLoader springFXMLLoader;

    public FormService(SpringFXMLLoader springFXMLLoader) {
        this.springFXMLLoader = springFXMLLoader;
    }

    private Stage getPrimaryStage() {
        return Jptv23JavaFxApplication.primaryStage;
    }
    public void loadLoginForm() {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/loginForm/loginForm.fxml");
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        getPrimaryStage().setScene(scene);
        getPrimaryStage().setTitle("JPTV23 библиотека - Вход");
        getPrimaryStage().centerOnScreen();
        getPrimaryStage().show();
    }
}
