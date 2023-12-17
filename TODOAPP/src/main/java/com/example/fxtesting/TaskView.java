package com.example.fxtesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;

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
    @FXML
    private Text tooManyTasksText;
    private int lineCount;
    File file = new File("C:\\Users\\Malte\\OneDrive\\Dokumenter\\GitHub\\FinalICERepository\\TODOAPP\\src\\SaveTask\\Tasks");

    String[] tasks = new String[11];

    private double count = 30;
    private double boxYPlace = 79.0;
    private double textYPlace = 76.0;

    ArrayList <TextField> textFields = new ArrayList<>();
    ArrayList <CheckBox> checkBoxes = new ArrayList<>();


    @FXML
    void goBackClicked() throws IOException {
        new SceneSwitch(taskAnchorPane,"loginSuccesfull.fxml");
    }



    @FXML
    void addNewTaskClicked(ActionEvent event) throws IOException {

        double max=406.0;

        if(textFields.size()<11) {

            if (textYPlace < max) {

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

                textFields.add(newTextField);
                checkBoxes.add(newCheckBox);
            }
        }
        else {
            tooManyTasksText.setText("You have exceeded the task limit");
        }
    }

    @FXML
    void saveListClicked(ActionEvent event) throws IOException {
        String saveTask1="";
        for (TextField t: textFields) {
            saveTask1+=t.getText() + System.lineSeparator();
        }
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Malte\\OneDrive\\Dokumenter\\GitHub\\FinalICERepository\\TODOAPP\\src\\SaveTask\\Tasks")) {

            fileWriter.write(saveTask1);

        } catch (IOException e) {
            e.printStackTrace();
        }

        new SceneSwitch(taskAnchorPane,"loginSuccesfull.fxml");
    }

    @FXML
    void loadTasksClick(ActionEvent event) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        double max=406.0;

        while(scan.hasNextLine()) {
            if (textFields.size() < 11) {

                if (textYPlace < max) {

                    CheckBox newCheckBox = new CheckBox();
                    TextField newTextField = new TextField();
                    newTextField.setText(scan.nextLine());
                    newCheckBox.setLayoutX(35.0);
                    newCheckBox.setLayoutY(boxYPlace + count);
                    newTextField.setLayoutX(61.0);
                    newTextField.setLayoutY(textYPlace + count);
                    newTextField.setPrefHeight(25.0);
                    newTextField.setPrefWidth(275.0);

                    anchorPaneaddNewList.getChildren().addAll(newCheckBox, newTextField);

                    boxYPlace += count;
                    textYPlace += count;

                    textFields.add(newTextField);
                    checkBoxes.add(newCheckBox);
                }
            }
        }
    }
}