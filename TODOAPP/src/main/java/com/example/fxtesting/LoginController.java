package com.example.fxtesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane LoginAnchorPane;

    @FXML
    void createAccountClicked(ActionEvent event) throws IOException {
        new SceneSwitch(LoginAnchorPane,"createAccount.fxml");
    }

    @FXML
    void loginClicked(ActionEvent event) throws IOException {

    }

}
