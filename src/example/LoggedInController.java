package example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button logout_button;
    @FXML
    private Label label_welcome;
    @FXML
    private Label label_fav_channel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logout_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DButility.changeScene(event, "sample.fxml", "Log in!", "null", "null");
            }
        });

    }

    public void setUserInformation(String username, String fav_channel) {
        label_welcome.setText("Welcome " + username + " !!!");
        label_fav_channel.setText("Your favourite YouTube channel is " + fav_channel + " !");

    }


}
