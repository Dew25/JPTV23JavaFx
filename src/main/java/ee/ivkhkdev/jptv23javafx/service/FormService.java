package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.tools.SpringFXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
    public void loadMainForm() {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/main/mainForm.fxml");
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        getPrimaryStage().setScene(scene);
        getPrimaryStage().setTitle("JPTV23 библиотека - главная");
        getPrimaryStage().centerOnScreen();
        getPrimaryStage().show();
    }
    public void loadRegistrationForm() {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/registration/registration.fxml");
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        getPrimaryStage().setScene(scene);
        getPrimaryStage().setTitle("JPTV23 библиотека - регистрация пользователя");
        getPrimaryStage().centerOnScreen();
        getPrimaryStage().show();
    }

    public Parent loadMenuForm() {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/menu/menuForm.fxml");
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadNewAuthorForm(){
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/author/newAuthorForm.fxml");
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        getPrimaryStage().setScene(scene);
        getPrimaryStage().setTitle("JPTV23 библиотека - добавление автора");
        getPrimaryStage().centerOnScreen();
        getPrimaryStage().show();
    }
    public void loadNewBookForm(){
        FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/book/newBookForm.fxml");
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        getPrimaryStage().setScene(scene);
        getPrimaryStage().setTitle("JPTV23 библиотека - добавление книги");
        getPrimaryStage().centerOnScreen();
        getPrimaryStage().show();
    }
}
