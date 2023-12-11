package com.example.fxml_manual;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;


public class titleScreen_ControllerClass {

    @FXML
    private AnchorPane TitleScreen;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void exit_f(ActionEvent event) {
        System.out.println("Exiting Application Success!");
        // Properly close the application
//        stage.close();
        Platform.exit();
    }

    @FXML
    void switch_to_game_select(ActionEvent event) {
        System.out.println("Play Button Clicked");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game_selection_screen.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            stage.getScene().setRoot(gameSelectionRoot);

        } catch (IOException e) {
            System.out.println("Something went wrong loading game_selection_screen.fxml: " + e.getMessage());
        }
    }

    @FXML

    void switchBackToTitleScene(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("title_screen.fxml"));
            Parent titleScreenRoot = fxmlLoader.load();

            if (stage != null) {
                // Set the content of the stage's scene to the title screen root
                stage.getScene().setRoot(titleScreenRoot);
            } else {
                System.out.println("Stage reference is null!");
            }
        } catch (IOException e) {
            System.out.println("Error loading titleScreen.fxml: " + e.getMessage());
        }
    }


    public void game_one(ActionEvent event){
        System.out.println("Game One!");
        // Add logic for game one actions
    }

    public void game_two(ActionEvent event){
        System.out.println("Game Two!");
        // Add logic for game two actions
    }

    public void game_three(ActionEvent event){
        System.out.println("Game Three!");
        // Add logic for game three actions
    }
}
