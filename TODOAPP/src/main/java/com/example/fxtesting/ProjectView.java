package com.example.fxtesting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ProjectView {
    @FXML
    private AnchorPane projectView;

    @FXML
    private Button createProject;

    @FXML
    private Button seeAllProjects;

    @FXML
    private Button deleteProject;

    @FXML
    private Button signOut;

    @FXML
    void createProjectClicked(ActionEvent actionEvent) throws IOException {
        //try (FileWriter fileWriter = new FileWriter("");

        new SceneSwitch(projectView,"Task-view.fxml");



    }

    @FXML
    void seeAllProjectsClicked(ActionEvent actionEvent) {
    }

    @FXML

    void deleteProjectClicked(ActionEvent actionEvent) {
    }

    @FXML

    void signOutClicked(ActionEvent actionEvent) {
    }
}
