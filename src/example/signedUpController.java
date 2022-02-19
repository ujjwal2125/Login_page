package example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class signedUpController implements Initializable {
    @FXML
    private Button signup_button;
    @FXML
    private Button button_login;
    @FXML
    private RadioButton rb_carryminati;
    @FXML
    private RadioButton rb_someone_else;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         final ToggleGroup toggleGroup = new ToggleGroup();
        rb_carryminati.setToggleGroup(toggleGroup);
        rb_someone_else.setToggleGroup(toggleGroup);

        rb_carryminati.setSelected(true);

        signup_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String togglename = ((RadioButton) toggleGroup.getSelectedToggle() ).getText();
                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()) {
                    DButility.signUpUser(event, tf_username.getText(), tf_password.getText(), togglename);
                } else {
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all informtion to sign up!");
                    alert.show();
                }


            }
        });

        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DButility.changeScene(event, "sample.fxml", "Log In!", null, null);
            }
        });
    }
}
