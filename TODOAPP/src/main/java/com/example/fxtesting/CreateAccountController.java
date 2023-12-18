package com.example.fxtesting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;


public class CreateAccountController {

    @FXML
    private AnchorPane createAccountAchor;

    @FXML
    private Button createAccountButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    private Button loginButton;

    @FXML
    private CheckBox showPasswordBtn;

    @FXML
    private AnchorPane accountCreated;

    @FXML
    private Text fieldEmptyText;


    @FXML
    void loginFromCreatedAccount(ActionEvent event) throws IOException {
        new SceneSwitch(accountCreated,"login.fxml");
    }

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        try (FileWriter fileWriter = new FileWriter("/Users/albertevallentin/Documents/GitHub/FinalICERepository/TODOAPP/src/Database/Users", true)) {
            if (!userNameField.getText().isBlank() && !passwordField.getText().isBlank()) {

                String userCredentials = userNameField.getText() + ";" + passwordField.getText() + System.lineSeparator();
                fileWriter.write(userCredentials);
                new SceneSwitch(createAccountAchor, "signupSucces.fxml");
            }

            else{
                fieldEmptyText.setText("Seems one of the fields were empty - pleasy try again.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception or handle it appropriately
        }
    }



    @FXML
    void goBackClicked(ActionEvent event) throws IOException {
        new SceneSwitch(createAccountAchor,"login.fxml");
    }

}

