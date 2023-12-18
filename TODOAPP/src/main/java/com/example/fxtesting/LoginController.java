package com.example.fxtesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginController {
    File file = new File("/Users/albertevallentin/Documents/GitHub/FinalICERepository/TODOAPP/src/Database/Users");

    @FXML
    private AnchorPane LoginAnchorPane;

    @FXML
    private Label incorrectCrLabel;

    @FXML
    void createAccountClicked(ActionEvent event) throws IOException {
        new SceneSwitch(LoginAnchorPane,"createAccount.fxml");
    }

    @FXML
    void loginClicked(ActionEvent event) throws IOException {
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] lineChop;
            lineChop = line.split(";");
            System.out.println(lineChop[0]);

            // Extract username and password from the split line
            String userN = lineChop[0].trim();
            String userP = lineChop[1].trim();

            if (userNameField.getText().equals(userN)&&passwordField.getText().equals(userP)){
                new SceneSwitch(LoginAnchorPane,"loginSuccesfull.fxml");
            }
            else {
                incorrectCrLabel.setText("Your credentials were incorrect \nPlease try again");
            }
        }
    }

    @FXML
    private Button createAccountButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;
}



