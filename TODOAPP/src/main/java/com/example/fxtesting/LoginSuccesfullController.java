package com.example.fxtesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class LoginSuccesfullController {

    @FXML
    private Button createAccountButton;

    @FXML
    private Button createAccountButton1;

    @FXML
    private Label incorrectCrLabel;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginSuccesfullAnchor;

    @FXML
    private Text welcomeUser;

    public String userN = "Null";


    @FXML
    void accountInformationClick(ActionEvent event) {

    }

    @FXML
    void signOutClick(ActionEvent event) throws IOException {
        new SceneSwitch(loginSuccesfullAnchor,"login.fxml");
    }

    @FXML
    void viewProjectsclick(ActionEvent event) throws IOException {
        new SceneSwitch(loginSuccesfullAnchor,"Task-View.fxml");
    }

    @FXML
    void onDragWelcome(MouseEvent event) {
        welcomeUser.setText(userN);
    }

    public void setUserN(String userNS) {
        userN = userNS;
    }

    //Test note
}
