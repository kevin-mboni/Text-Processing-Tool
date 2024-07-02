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

        primaryStage.setTitle("Text Processing Tool");

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
            try {
                String result = textProcessingModule.searchPattern(patternInput.getText(), textInput.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Search Results");
                alert.setHeaderText(null);
                alert.setContentText(result);

                alert.showAndWait();
            } catch (Exception ex) {
                showErrorAlert("Error during search operation: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(searchButton, 1, 1);

        // Replace button
        Button replaceButton = new Button("Replace");
        replaceButton.setOnAction(e -> {
            try {
                String result = textProcessingModule.replacePattern(patternInput.getText(), replaceInput.getText(), textInput.getText());
                textInput.setText(result);
            } catch (Exception ex) {
                showErrorAlert("Error during replace operation: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(replaceButton, 1, 2);

        // Data Management Section

        // Input for List data management
        TextField listInput = new TextField();
        listInput.setPromptText("Enter data for List");
        GridPane.setConstraints(listInput, 0, 3);

        // Add to List button
        Button addToListButton = new Button("Add to List");
        addToListButton.setOnAction(e -> {
            try {
                dataManagementModule.addToList(listInput.getText());
                listInput.clear();
            } catch (Exception ex) {
                showErrorAlert("Error adding to list: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(addToListButton, 1, 3);

        // Remove from List button
        Button removeFromListButton = new Button("Remove from List");
        removeFromListButton.setOnAction(e -> {
            try {
                dataManagementModule.removeFromList(listInput.getText());
                listInput.clear();
            } catch (Exception ex) {
                showErrorAlert("Error removing from list: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(removeFromListButton, 2, 3);

        // Retrieve List button
        Button getListButton = new Button("Get List");
        getListButton.setOnAction(e -> {
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("List Contents");
                alert.setHeaderText(null);
                alert.setContentText(dataManagementModule.getList().toString());

                alert.showAndWait();
            } catch (Exception ex) {
                showErrorAlert("Error retrieving list: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(getListButton, 3, 3);

        // Input for Set data management
        TextField setInput = new TextField();
        setInput.setPromptText("Enter data for Set");
        GridPane.setConstraints(setInput, 0, 4);

        // Add to Set button
        Button addToSetButton = new Button("Add to Set");
        addToSetButton.setOnAction(e -> {
            try {
                dataManagementModule.addToSet(setInput.getText());
                setInput.clear();
            } catch (Exception ex) {
                showErrorAlert("Error adding to set: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(addToSetButton, 1, 4);

        // Remove from Set button
        Button removeFromSetButton = new Button("Remove from Set");
        removeFromSetButton.setOnAction(e -> {
            try {
                dataManagementModule.removeFromSet(setInput.getText());
                setInput.clear();
            } catch (Exception ex) {
                showErrorAlert("Error removing from set: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(removeFromSetButton, 2, 4);

        // Retrieve Set button
        Button getSetButton = new Button("Get Set");
        getSetButton.setOnAction(e -> {
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Set Contents");
                alert.setHeaderText(null);
                alert.setContentText(dataManagementModule.getSet().toString());

                alert.showAndWait();
            } catch (Exception ex) {
                showErrorAlert("Error retrieving set: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(getSetButton, 3, 4);

        // Key and Value input for Map
        TextField keyInput = new TextField();
        keyInput.setPromptText("Enter key");
        GridPane.setConstraints(keyInput, 0, 5);

        TextField valueInput = new TextField();
        valueInput.setPromptText("Enter value");
        GridPane.setConstraints(valueInput, 1, 5);

        // Add to Map button
        Button addToMapButton = new Button("Add to Map");
        addToMapButton.setOnAction(e -> {
            try {
                dataManagementModule.addToMap(keyInput.getText(), Integer.parseInt(valueInput.getText()));
                keyInput.clear();
                valueInput.clear();
            } catch (Exception ex) {
                showErrorAlert("Error adding to map: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(addToMapButton, 2, 5);

        // Remove from Map button
        Button removeFromMapButton = new Button("Remove from Map");
        removeFromMapButton.setOnAction(e -> {
            try {
                dataManagementModule.removeFromMap(keyInput.getText());
                keyInput.clear();
            } catch (Exception ex) {
                showErrorAlert("Error removing from map: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(removeFromMapButton, 3, 5);

        // Retrieve Map button
        Button getMapButton = new Button("Get Map");
        getMapButton.setOnAction(e -> {
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Map Contents");
                alert.setHeaderText(null);
                alert.setContentText(dataManagementModule.getMap().toString());

                alert.showAndWait();
            } catch (Exception ex) {
                showErrorAlert("Error retrieving map: " + ex.getMessage());
            }
        });
        GridPane.setConstraints(getMapButton, 4, 5);

        // Add all controls to the grid
        grid.getChildren().addAll(
                textInput, patternInput, replaceInput, searchButton, replaceButton,
                listInput, addToListButton, removeFromListButton, getListButton,
                setInput, addToSetButton, removeFromSetButton, getSetButton,
                keyInput, valueInput, addToMapButton, removeFromMapButton, getMapButton
        );

        // Scene and stage setup
        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
