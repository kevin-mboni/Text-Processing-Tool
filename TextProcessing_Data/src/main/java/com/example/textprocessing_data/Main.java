package com.example.textprocessing_data;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private TextProcessingModule textProcessingModule;
    private DataManagementModule dataManagementModule;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        textProcessingModule = new TextProcessingModule();
        dataManagementModule = new DataManagementModule();

        primaryStage.setTitle("TPT");

        // GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Text input
        TextArea textInput = new TextArea();
        textInput.setPromptText("Enter text here");
        GridPane.setConstraints(textInput, 0, 0);

        // Regex pattern input
        TextField patternInput = new TextField();
        patternInput.setPromptText("Enter word");
        GridPane.setConstraints(patternInput, 0, 1);

        // Replace input
        TextField replaceInput = new TextField();
        replaceInput.setPromptText("Enter replacement text");
        GridPane.setConstraints(replaceInput, 0, 2);

        // Search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            String result = textProcessingModule.searchPattern(patternInput.getText(), textInput.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Results");
            alert.setHeaderText(null);
            alert.setContentText(result);
            alert.showAndWait();
        });
        GridPane.setConstraints(searchButton, 1, 1);

        // Replace button
        Button replaceButton = new Button("Replace");
        replaceButton.setOnAction(e -> {
            String result = textProcessingModule.replacePattern(patternInput.getText(), replaceInput.getText(), textInput.getText());
            textInput.setText(result);
        });
        GridPane.setConstraints(replaceButton, 1, 2);

        // Add all controls to the grid
        grid.getChildren().addAll(textInput, patternInput, replaceInput, searchButton, replaceButton);

        // Scene and stage setup
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

