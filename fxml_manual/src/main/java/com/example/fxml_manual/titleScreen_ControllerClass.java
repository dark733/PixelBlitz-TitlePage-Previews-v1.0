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
import java.util.Objects;

import javafx.scene.layout.AnchorPane;


public class titleScreen_ControllerClass {
    //PixelBlitz obj_main = new PixelBlitz();
    private final soundApi obj_sound = new soundApi();
    private final menu_bar menu_bar_obj = new menu_bar();
    private final game_one gameOne_obj = new game_one();
    private final game_two gameTwo_obj = new game_two();
    game_three gameThree_obj = new game_three();

    @FXML
    //private AnchorPane TitleScreen;
    public  Stage stage;

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    @FXML
    void exit_f(ActionEvent event) {
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Exiting Application Success!" + event );
        // Properly close the application
//        stage.close();
        Platform.exit();
    }

    @FXML
    void switch_to_game_select(ActionEvent event) {
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Play Button Clicked" + event );
        obj_sound.play_game_selection_screen_sound();
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

//    void switchBackToTitleScene(ActionEvent event) {
//        go_back();
//    }


    public void game_one_clicked(ActionEvent event){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Game One!" + event);
        gameOne_obj.game_one_event();
        // Add logic for game one actions
    }

    public void game_two_clicked(ActionEvent event){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Game Two!" + event );
        gameTwo_obj.game_two_event();
        // Add logic for game two actions
    }

    public void game_three_clicked(ActionEvent event){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Game Three!"+event );
        gameThree_obj.game_three_event();

        // Add logic for game three actions
    }
    public void documentation_clicked(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("documentation_clicked!"+e );
        menu_bar_obj.documentation_event(stage);

    }
    public void reference_clicked(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("reference_clicked!"+e);
        menu_bar_obj.references_event(stage);

    }
    public void switch_title(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Go Back clicked!"+e);
        System.out.println(null == this.stage ? "Stage is null " : "stage is not null!");
       // menu_bar_obj.switchBackToGameSelectionScreen(stage);
    }
    public void switch_title_one(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Go Back clicked!" +e );
        if (this.stage == null){
            System.out.println("Stage is null ");
        }
        else{
            System.out.println("stage is not null!");
        }
        // menu_bar_obj.switchBackToGameSelectionScreen(stage);
    }
    public void credits_clicked(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("credits_clicked!"+e);
        obj_sound.credit_screen_sound();
        menu_bar_obj.credits_event(stage);

    }
    public void license_clicked_test_function(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("license_clicked from test function()!"+e );
        menu_bar_obj.license_event(stage);
        if (stage == null){
            System.out.println("Stage is null ");
        }
        else{
            System.out.println("stage is not null!");
        }


    }
    public void license_clicked(ActionEvent e){
        System.out.println("license_clicked!"+e );
        menu_bar_obj.license_event(stage);
        if (stage == null){
            System.out.println("Stage is null ");
        }
        else{
            System.out.println("stage is not null!");
        }


    }
    public void faq_clicked(){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("FAQ_clicked!");
        menu_bar_obj.faq_event(stage);
    }
    public void forceexit_clicked(){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("force_exit_clicked!");
        menu_bar_obj.force_exit_event();
    }
    public void muteaudio_clicked(){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("mute_audio_clicked!");
        menu_bar_obj.mute_audio_event();
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
            System.out.println("Something went wrong loading Credits.fxml: " + e.getMessage());

        }

    }
    public void license_event(Stage stage){
        try {
            if(stage == null){
                System.out.println("Stage is null inside license_event() method");
            }
            else{
                System.out.println("Stage is not null inside license_event() method");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("license.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            Objects.requireNonNull(stage).getScene().setRoot(gameSelectionRoot);

        }
        catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());

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

        }

    }
    public void switchBackToGameSelectionScreen(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Credits.fxml"));
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