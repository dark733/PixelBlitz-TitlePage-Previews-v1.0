package com.example.fxml_manual;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;


public class titleScreen_ControllerClass {
    menu_bar menu_bar_obj = new menu_bar();
    game_one gameOne_obj = new game_one();
    game_two gameTwo_obj = new game_two();
    game_three gameThree_obj = new game_three();

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
        go_back(stage);
    }


    public void game_one_clicked(ActionEvent event){
        System.out.println("Game One!");
        gameOne_obj.game_one_event();
        // Add logic for game one actions
    }

    public void game_two_clicked(ActionEvent event){
        System.out.println("Game Two!");
        gameTwo_obj.game_two_event();
        // Add logic for game two actions
    }

    public void game_three_clicked(ActionEvent event){
        System.out.println("Game Three!");
        gameThree_obj.game_three_event();

        // Add logic for game three actions
    }
    public void documentation_clicked(ActionEvent e){
        System.out.println("documentation_clicked!");
        menu_bar_obj.documentation_event(stage);

    }
    public void reference_clicked(ActionEvent e){
        System.out.println("reference_clicked!");
        menu_bar_obj.references_event(stage);

    }
    public void credits_clicked(ActionEvent e){
        System.out.println("credits_clicked!");
        menu_bar_obj.credits_event(stage);

    }
    public void license_clicked(ActionEvent e){
        System.out.println("license_clicked!");
        menu_bar_obj.license_event(stage);

    }
    public void faq_clicked(){
        System.out.println("FAQ_clicked!");
        menu_bar_obj.faq_event(stage);
    }
    public void forceexit_clicked(){
        System.out.println("force_exit_clicked!");
        menu_bar_obj.force_exit_event();
    }
    public void muteaudio_clicked(){
        System.out.println("mute_audio_clicked!");
        menu_bar_obj.mute_audio_event();
    }
    public void go_back(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("title_screen2.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        }
        catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());
            //e.printStackTrace();
        }
        catch(NullPointerException e){
            System.out.println("Null Pointer Exception Caught " + e);
        }
        catch (Exception e){
            System.out.println("Exception Caught" + e);
        }

    }
}
class menu_bar{
    public void documentation_event(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("documentation.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        }
        catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());
            e.printStackTrace();
        }

        catch(NullPointerException e){
            System.out.println("Null Pointer Exception Caught " + e);

        }
        catch(Exception e){
            System.out.println("Exception Caught" + e);
        }
    }
    public void references_event(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("References.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        }
        catch (IOException e) {
            System.out.println("Something went wrong loading reference.fxml: " + e.getMessage());
            e.printStackTrace();
        }

        catch(NullPointerException e){
            System.out.println("Null Pointer Exception Caught " + e);

        }
        catch(Exception e){
            System.out.println("Exception Caught" + e);
        }

    }
    public void credits_event(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Credits.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        }
        catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());
            e.printStackTrace();
        }

    }
    public void license_event(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("license.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        }
        catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());
            e.printStackTrace();
        }

    }
    public void faq_event(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("faq.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        }
        catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());
            e.printStackTrace();
        }

    }
    public void force_exit_event(){

    }
    public void mute_audio_event(){

    }
}
class game_one{
    public void game_one_event(){

    }
}
class game_two{
    public void game_two_event(){

    }
}
class game_three{
    public void game_three_event(){

    }
}