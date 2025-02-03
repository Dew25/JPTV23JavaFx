package ee.ivkhkdev.jptv23javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class Jptv23JavaFxApplicationController {
    @FXML private Label label;
    @FXML
    private void buttonClick(){
        label.setText("Hello JPTV23!");
    }
}
