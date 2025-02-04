package ee.ivkhkdev.jptv23javafx;

import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
import ee.ivkhkdev.jptv23javafx.tools.SpringFXMLLoader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Jptv23JavaFxApplication extends Application {
	public static AppUser currentUser;
	public static Stage primaryStage;
	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Jptv23JavaFxApplication.class, args);
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Jptv23JavaFxApplication.primaryStage = primaryStage;
		SpringFXMLLoader springFXMLLoader = applicationContext.getBean(SpringFXMLLoader.class);
		FXMLLoader fxmlLoader = springFXMLLoader.load("/ee/ivkhkdev/jptv23javafx/loginForm/loginForm.fxml");
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JPTV23 библиотека");
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	@Override
	public void stop(){
		applicationContext.close();
		Platform.exit();
	}
}
