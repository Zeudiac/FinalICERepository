package com.example.fxtesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TaskView {

    @FXML
    private AnchorPane taskAnchorPane;
    @FXML
    private AnchorPane anchorPaneaddNewList;


    @FXML
    private Button saveListButton;
    @FXML
    private Button addNewListButton;
    @FXML
    private  Button goBackButton;
    @FXML
    private TextField checkText1;
    @FXML
    private CheckBox checkBox1;


    private double count = 30;
    private double boxYPlace = 79.0;
    private double textYPlace = 76.0;


    @FXML
    void goBackClicked() throws IOException {
        new SceneSwitch(taskAnchorPane,"Login.fxml");
    }



    @FXML
    void addNewTaskClicked(ActionEvent event) throws IOException {

        double max=406.0;



            if(textYPlace<max) {

                CheckBox newCheckBox = new CheckBox();
                TextField newTextField = new TextField();

                newTextField.setPromptText("What do you have in mind?");

                newCheckBox.setLayoutX(35.0);
                newCheckBox.setLayoutY(boxYPlace + count);
                newTextField.setLayoutX(61.0);
                newTextField.setLayoutY(textYPlace + count);
                newTextField.setPrefHeight(25.0);
                newTextField.setPrefWidth(275.0);

                anchorPaneaddNewList.getChildren().addAll(newCheckBox, newTextField);

                boxYPlace += count;
                textYPlace += count;
            }
    }

    @FXML
    void saveListClicked(ActionEvent event) throws IOException {

        try (FileWriter fileWriter = new FileWriter("/Users/alfredofernandez/Desktop/Datamatiker/FinalICERepository/TODOAPP/src/SaveTask/Tasks")){

            String saveTask= checkText1.getText()+";"+ System.lineSeparator();

            fileWriter.write(saveTask);

        } catch (IOException e){
            e.printStackTrace();
        }



        new SceneSwitch(taskAnchorPane,"Login.fxml");
    }

}
