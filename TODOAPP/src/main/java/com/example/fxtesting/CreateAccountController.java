package com.example.fxtesting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class CreateAccountController {

    @FXML
    private AnchorPane createAccountAchor;

    @FXML
    void goBackClicked(ActionEvent event) throws IOException {
        new SceneSwitch(createAccountAchor,"login.fxml");
    }

}

